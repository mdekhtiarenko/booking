package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.converter.RoomConverter;
import com.berezanskyi.booking.converter.RoomDtoConverter;
import com.berezanskyi.booking.dtos.CreateRoomDto;
import com.berezanskyi.booking.dtos.RoomDto;
import com.berezanskyi.booking.entity.Room;
import com.berezanskyi.booking.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomServices roomServices;

    @Autowired
    private RoomConverter roomConverter;

    @Autowired
    private RoomDtoConverter roomDtoConverter;



    @PostMapping
    public boolean createRoom(@RequestBody CreateRoomDto createRoomDto){
        return roomServices.createRoom(roomConverter.convert(createRoomDto));
    }

    @PatchMapping("/{room_name}")
    public boolean editRoom(@PathVariable String room_name, @RequestBody Map<String, String> roomFieldsToEdit)  {
        return roomServices.editRoom(room_name, roomFieldsToEdit);
    }

    @DeleteMapping("/{room_name}")
    public boolean deleteRoomByRoomName(@PathVariable String room_name) {
        return roomServices.deleteRoomByRoomName(room_name);
    }

    @GetMapping
    public List<RoomDto> getAllUsers() {
        return roomDtoConverter.convertAll(roomServices.getAllRooms());
    }

    @GetMapping("/{name}")
    public Optional<Room> getUserByName(@PathVariable String name) {
        return roomServices.findRoomByRoomName(name);
    }
}
