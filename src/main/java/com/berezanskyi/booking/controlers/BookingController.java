package com.berezanskyi.booking.controlers;


import com.berezanskyi.booking.converter.BookingDtoConverter;
import com.berezanskyi.booking.dtos.BookingDto;
import com.berezanskyi.booking.services.iml.DefaultBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping() // краще винести сюди "/booking" бо воно в тебе є в кожному ендпоінті
public class BookingController {

    @Autowired
    private DefaultBookingService defaultBookingService; // завжди автовайри інтерфейс а не реалізацію, так ти зможеш
    // її підмінити без зміни коду прокинувши наприклад якийсь профіль. Тут це наврядчи колись знадобиться але це загальний підхід
    // Єдине виключення яке я допускаю це конвертери, але це лише я,  і думаю коли ти прийдеш на проект тобі скажуть нононо і на конвертери
    //+ я тут подивився, у тебе ця проблемка просліджується в усьому проекті тому пройдися по всьму проекту і пофікси, я не буду писати в кожному місці

    @Autowired
    private BookingDtoConverter bookingDtoConverter;


    @PostMapping("/booking/{roomName}")
    public void bookingRoom(
            @PathVariable String roomName,
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
            @RequestParam(value = "endDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar endDateTime) {
        defaultBookingService.bookingRoom(roomName, startDateTime, endDateTime); // defaultBookingService.bookRoom буде
        // краще, так зрозуміло що ти робиш в методі
    }

    @GetMapping("/booking")
    public List<BookingDto> getAllBookingForSchedule(
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
            //мені здається в @RequestParam можна опустити value якщо воно збігається з імям змінної
            //+ в ідеалі оцю аннотацію @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") обгорнути в кастомну аннотацію
            // типу @BookingDateFormat щоб не копіпастити щоразу патерн
            @RequestParam(value = "endDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar endDateTime){
        System.out.println(startDateTime + " " +  endDateTime);
        return bookingDtoConverter.convertAll(defaultBookingService.getAllBookingForSchedule(startDateTime, endDateTime));

    }

    @GetMapping("/booking/room/{roomName}")
    public List<BookingDto> getBookingScheduleForRoom (
            @PathVariable String roomName,
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
            @RequestParam(value = "endDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar endDateTime){
        return bookingDtoConverter.convertAll(defaultBookingService.getBookingScheduleForRoom(roomName, startDateTime, endDateTime));
    }

    @GetMapping("/booking/user/{login}")
    public List<BookingDto> getBookingScheduleForUser (
            @PathVariable String login,
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
            @RequestParam(value = "endDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar endDateTime){
        return bookingDtoConverter.convertAll(defaultBookingService.getBookingScheduleForUser(login, startDateTime, endDateTime));
    }

}
