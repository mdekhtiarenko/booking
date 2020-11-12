package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

   // Optional<Room> deleteByRoom_Name(String roomName);

    Optional<Room> findByRoom_Name(String room_name);
}
