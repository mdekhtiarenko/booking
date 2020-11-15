package com.berezanskyi.booking.services;

import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomServices {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MyBeanUntil myBeanUntil;


    public boolean createRoom(Room room) {
        if (roomIsPresent(room.getRoomName())) {
            return false;
        } else {
            roomRepository.save(room);
            return true;
        }
    }

    @Transactional
    public Optional<Room> findRoomByRoomName(String room_name) {
        return roomRepository.findByRoomName(room_name);
    }

    @Transactional
    public boolean deleteRoomByRoomName(String roomName) {
        if (roomIsPresent(roomName)) {
            roomRepository.deleteByRoomName(roomName);
            return true;
        } else {
            return false;
        }
    }

    public boolean editRoom(String roomName, Map<String, String> roomFieldsToEdit) {
        Optional<Room> roomOptional = roomRepository.findByRoomName(roomName);

        if (roomOptional.isPresent()) {
            Room roomWithEditsFields = objectMapper.convertValue(roomFieldsToEdit, Room.class);
            Room roomEdits = roomOptional.get();
            try {
                myBeanUntil.copyProperties(roomEdits, roomFieldsToEdit);
                roomRepository.save(roomEdits);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    private boolean roomIsPresent(String name) {
        return roomRepository.findByRoomName(name).isPresent();
    }

}
