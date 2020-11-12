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


/*    public boolean createRoom(Room room){
        if (roomIsPresent(room.getRoom_name())){
            return false;
        } else {
            roomRepository.save(room);
            return true;
        }
    }*/

/*

    @Transactional
    public boolean deleteRoomByRoomName(String roomName) {
        if (roomIsPresent(roomName)) {
            roomRepository.deleteByRoom_Name(roomName);
            return true;
        } else {
            return false;
        }
    }

    public boolean editRoom(String roomName, Map<String, String> roomFieldsToEdit) {
        Optional<Room> roomOptional = roomRepository.findByRoom_Name(roomName);

        if (roomOptional.isPresent()) {
            Room roomWithEditsFields = objectMapper.convertValue(roomFieldsToEdit, Room.class);
            Room roomEdits = roomOptional.get();
            try {
                myBeanUntil.copyProperties(roomEdits, roomWithEditsFields);
                roomRepository.save(roomEdits);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }

    }*/

    @Transactional
    public Optional<Room> findRoomByRoomName(String roomName) {
        return roomRepository.findByRoom_Name(roomName);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

/*    private boolean roomIsPresent(String roomName) {
        return roomRepository.findByRoom_Name(roomName).isPresent();
    }*/

}
