package com.berezanskyi.booking.services;

import com.berezanskyi.booking.entity.Booking;

import java.util.Calendar;
import java.util.List;

public interface BookingService {

    void bookingRoom(String roomName, Calendar startDateTime, Calendar endDateTime);

    List<Booking> getAllBookingForSchedule(Calendar startDateTime, Calendar endDateTime);

    List<Booking> getBookingScheduleForRoom(String roomName, Calendar startDateTime, Calendar endDateTime);

    List<Booking> getBookingScheduleForUser(String login, Calendar startDateTime, Calendar endDateTime);
}
