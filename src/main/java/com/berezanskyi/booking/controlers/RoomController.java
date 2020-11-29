package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.converter.RoomConverter;
import com.berezanskyi.booking.converter.RoomDtoConverter;
import com.berezanskyi.booking.dtos.CreateUpdateRoomDto;
import com.berezanskyi.booking.dtos.RoomDto;
import com.berezanskyi.booking.services.iml.DefaultRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private DefaultRoomService defaultRoomService;

    @Autowired
    private RoomConverter roomConverter;

    @Autowired
    private RoomDtoConverter roomDtoConverter;


    @PostMapping
    public void createRoom(@RequestBody CreateUpdateRoomDto createUpdateRoomDto) {
        defaultRoomService.createRoom(roomConverter.convert(createUpdateRoomDto));
    }

    @PatchMapping("/{roomName}") //  це вже не Patch a Put бо ти оновлюєш всі поля
    public void editRoom(@PathVariable String roomName, @RequestBody CreateUpdateRoomDto createUpdateRoomDto) {
        defaultRoomService.editRoom(roomName, roomConverter.convert(createUpdateRoomDto));
    }

    @DeleteMapping("/{roomName}")
    public void deleteRoomByRoomName(@PathVariable String roomName) {
        defaultRoomService.deleteRoomByName(roomName);
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {
        return roomDtoConverter.convertAll(defaultRoomService.getAllRooms());
    }


}
