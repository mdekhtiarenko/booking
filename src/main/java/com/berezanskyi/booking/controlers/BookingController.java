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
@RequestMapping()
public class BookingController {

    @Autowired
    private DefaultBookingService defaultBookingService;

    @Autowired
    private BookingDtoConverter bookingDtoConverter;


    @PostMapping("/booking/{roomName}")
    public void bookingRoom(
            @PathVariable String roomName,
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
            @RequestParam(value = "endDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar endDateTime) {
        defaultBookingService.bookingRoom(roomName, startDateTime, endDateTime);
    }

    @GetMapping("/booking")
    public List<BookingDto> getAllBookingForSchedule(
            @RequestParam(value = "startDateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Calendar startDateTime,
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
