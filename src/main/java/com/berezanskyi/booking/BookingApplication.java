package com.berezanskyi.booking;

import com.berezanskyi.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication {



	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);

	}

}
