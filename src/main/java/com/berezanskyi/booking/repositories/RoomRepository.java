package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
