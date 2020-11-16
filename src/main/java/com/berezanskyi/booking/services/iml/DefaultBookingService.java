package com.berezanskyi.booking.services.iml;


import com.berezanskyi.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookingService {

    @Autowired
    private BookingRepository bookingRepository;



}
