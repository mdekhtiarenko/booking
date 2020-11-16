package com.berezanskyi.booking.services;

import com.berezanskyi.booking.entity.Room;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    void createRoom(Room room);

    void editRoom(String roomName, Room editRoom);

    @Transactional
    void deleteRoomByName(String roomName);

    Optional<Room> findRoomByName(String roomName);

    List<Room> getAllRooms();
}
