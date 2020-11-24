package com.berezanskyi.booking.services.iml;

import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.exeption.BookingException;
import com.berezanskyi.booking.repositories.RoomRepository;
import com.berezanskyi.booking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultRoomService implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void createRoom(Room room)  {
        if (findRoomByName(room.getRoomName()).isPresent()){
            throw new BookingException("Room with roomName " + room.getRoomName() + " already exists", HttpStatus.BAD_REQUEST);
        }
        roomRepository.save(room);
    }

    @Override
    public void editRoom(String roomName, Room editRoom) {
        Room room = roomRepository.findByRoomName(roomName)
                .orElseThrow(() -> new BookingException("Room with roomName " + roomName + " does not exists", HttpStatus.NOT_FOUND));
        editRoom.setId(room.getId());
        roomRepository.save(editRoom);
    }

    @Override
    @Transactional
    public void deleteRoomByName(String roomName) {
        if (!roomRepository.findByRoomName(roomName).isPresent()){
            throw new BookingException("Room with roomName " + roomName + " does not exists", HttpStatus.NOT_FOUND);
        }
        roomRepository.deleteByRoomName(roomName);
    }

    @Override
    public Optional<Room> findRoomByName(String roomName) {
        return roomRepository.findByRoomName(roomName);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }


}
