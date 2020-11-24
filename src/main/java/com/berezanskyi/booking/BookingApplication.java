package com.berezanskyi.booking;

import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.repositories.BookingRepository;
import com.berezanskyi.booking.repositories.RoomRepository;
import com.berezanskyi.booking.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(UserRepository userRepository, RoomRepository roomRepository){
		return args -> {

			userRepository.saveAll(new ArrayList<>(
					Arrays.asList(
							User.builder()
									.firstName("John")
									.surname("Smith")
									.login("jsmith")
									.password("qwerty")
									.build(),
							User.builder()
									.firstName("Jane")
									.surname("Doe")
									.login("jdoe")
									.password("mySecret")
									.build())));

			roomRepository.saveAll(new ArrayList<>(
					Arrays.asList(
							Room.builder()
									.roomName("Large Room")
									.locationDescription("1st floor")
									.numberOfSeats(10)
									.projector(true)
									.phoneNumber("22-22-22-22")
									.build(),
							Room.builder()
									.roomName("Medium Room")
									.locationDescription("1st floor")
									.numberOfSeats(6)
									.projector(true)
									.build(),
							Room.builder()
									.roomName("Small Room")
									.locationDescription("wnd floor")
									.numberOfSeats(4)
									.build()
					)
			));
		};
	}

}
