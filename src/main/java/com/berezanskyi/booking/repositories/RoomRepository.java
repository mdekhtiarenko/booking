package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    long deleteByRoomName(String roomName);

    Optional<Room> findByRoomName(String roomName);
}
