package com.berezanskyi.booking.services;


import com.berezanskyi.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;



}
