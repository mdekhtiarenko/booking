package com.berezanskyi.booking.controlers;


import com.berezanskyi.booking.entity.Booking;
import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping()
    public boolean bookRoom(){




        return false;
    }

}
