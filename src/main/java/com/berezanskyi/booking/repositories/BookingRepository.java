package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
