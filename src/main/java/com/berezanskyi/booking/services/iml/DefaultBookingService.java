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

import java.util.*;
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
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public void bookingRoom(String roomName, Calendar startDateTime, Calendar endDateTime) {
        Optional<Room> room = defaultRoomService.findRoomByName(roomName);
        if (room.isPresent()) {
            if (startDateTime.before(endDateTime) && endDateTime != null) {
                boolean isFree = true;
                List<Booking> bookings = room.get().getBookings();
                for (Booking booking : bookings) {
                    if (!isOverlapping(startDateTime, endDateTime, booking.getStartDateTime(), booking.getEndDateTime())) {
                        isFree = false;
                    }
                }
                if (isFree) {
                    bookingRepository.save(
                            Booking.builder()
                                    .room(room.get())
                                    //.user() ще не додав Spring Security
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
        Optional<Room> room = defaultRoomService.findRoomByName(roomName);
        if (room.isPresent()) {

            return getBookingSchedule(room.get().getBookings(), startDateTime, endDateTime);
        }
        throw new BookingException("Room with roomName " + roomName + " does not exists", HttpStatus.NOT_FOUND);

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
