package com.berezanskyi.booking.services.iml;


import com.berezanskyi.booking.repositories.BookingRepository;
import com.berezanskyi.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class DefaultBookingService implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public void bookRoom(String login, String roomName, Calendar startTime, Calendar endTime){
      /*  if (startTime.before(endTime)){

        }*/
    }



}
