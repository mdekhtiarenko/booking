package com.berezanskyi.booking.services.iml;


import com.berezanskyi.booking.entity.Booking;
import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.exeption.BookingException;
import com.berezanskyi.booking.repositories.BookingRepository;
import com.berezanskyi.booking.repositories.RoomRepository;
import com.berezanskyi.booking.repositories.UserRepository;
import com.berezanskyi.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultBookingService implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DefaultRoomService defaultRoomService;

    @Autowired
    private DefaultUserService defaultUserService;

    @Autowired
    private UserRepository userRepository; //Непотрібні залежності! за таке можна бити по рукам.
    @Autowired
    private RoomRepository roomRepository; //+1


    @Override
    public void bookingRoom(String roomName, Calendar startDateTime, Calendar endDateTime) {
        Optional<Room> room = defaultRoomService.findRoomByName(roomName);// тобі фронт передає ім'я кімнати,
        // єдиний випадок коли ти нічого не маєш знайти за цим ім'ям - коли фронт прислав якусь фігню тому тут не гріх
        // зробити .orElseThrow і кинути якийсь кастомний ексепшин з нормальним меседжом і тоді прибрати if(){}
        if (room.isPresent()) {
            if (startDateTime.before(endDateTime) && endDateTime != null) {

                // винеси в окремий приватний метод, і заюзай стрім
                // Коли я заходжу читати публічний метод сервіса мені не цікаво читати деталі того як конкретно ти
                // визначаєш що кімната вільна, я зхочу бачити код тезами, типу якщр кімна вільна букай, якщо ні - ні,
                // а як конкретно ти це зрозумієш - я якщо мені стане цікаво зайду в приватний метод і почитаю
                boolean isFree = true;
                List<Booking> bookings = room.get().getBookings();
                for (Booking booking : bookings) {
                    if (!isOverlapping(startDateTime, endDateTime, booking.getStartDateTime(), booking.getEndDateTime())) {
                        isFree = false;
                    }
                }

                //мені задається тут потрібно зробити else з throw кастомного ексепшина з нормальним меседжем щоб у
                // випадку якщо не можна забронити - фронт(і користувач) зрозумів що таки нічого не вийшло, бо зараз
                // буде 200 OK за будь яких обставин
                if (isFree) {
                    bookingRepository.save(
                            Booking.builder()
                                    .room(room.get())
                                    //.user() ще не додав Spring Security <- додавай спрінг секюріті:)
                                    .startDateTime(startDateTime)
                                    .endDateTime(endDateTime)
                                    .build()
                    );
                }

            }
        }
    }

    @Override
    public List<Booking> getAllBookingForSchedule(Calendar startDateTime, Calendar endDateTime) {
        return getBookingSchedule(bookingRepository.findAll(), startDateTime, endDateTime);
    }

    @Override
    public List<Booking> getBookingScheduleForRoom(String roomName, Calendar startDateTime, Calendar endDateTime) {
        // я б писав якось так, е люблю коли багато віток іфів якщо їх можна уникати,
        // хоча якщо вже на те пішло - можна взагалі не тягнути кімату а відразу написати запит щоб тягнути бронювання за кімнатою
        // спробуй зробити так
       Room room = defaultRoomService.findRoomByName(roomName)
                .orElseThrow(() -> new BookingException("Room with roomName " + roomName + " does not exists", HttpStatus.NOT_FOUND));
       return getBookingSchedule(room.getBookings(), startDateTime, endDateTime);

    }

    @Override
    public List<Booking> getBookingScheduleForUser(String login, Calendar startDateTime, Calendar endDateTime) {
        Optional<User> user = defaultUserService.findUserByLogin(login);
        if (user.isPresent()) {
            return getBookingSchedule(user.get().getBookings(), startDateTime, endDateTime);
        }
        throw new BookingException("User with login " + login + " does not exists", HttpStatus.NOT_FOUND);
    }


    private boolean isOverlapping(Calendar startA, Calendar endA, Calendar startB, Calendar endB) {
        return startA.after(endB) && startB.before(endA);
    }

    //Взагалі це що ти тут зробив воно непогане, воно читається, зрозуміло в чому ідея і тд, але, для того щоб
    // відфільтрувати за датою ти тягнеш абсолютно всі записи з бд, а якщо їх там буде справді багато, наприклад якійсь
    // історичні дані за останні 5 років то працюватиме в тебе це повільно, якщо ще й не вивалиться з OutOfMemoryError
    // тому оці всі фільтрування бажано робити прямо в бд
    // тому перепиши це так щоб це працювало прямо з бд
    private List<Booking> getBookingSchedule(List<Booking> bookings, Calendar startDateTime, Calendar endDateTime) {
        if (startDateTime == null && endDateTime == null){
            return bookings;
        }

        if (endDateTime != null && startDateTime == null){
            return bookings.stream()
                    .filter(booking -> booking.getEndDateTime().before(endDateTime))
                    .collect(Collectors.toList());
        }

        if (endDateTime == null){
            return bookings.stream()
                    .filter(booking -> booking.getStartDateTime().after(startDateTime))
                    .collect(Collectors.toList());
        }


        return bookings.stream()
                .filter(booking -> booking.getStartDateTime().after(startDateTime)
                        && booking.getEndDateTime().before(endDateTime))
                .collect(Collectors.toList());
    }


}
