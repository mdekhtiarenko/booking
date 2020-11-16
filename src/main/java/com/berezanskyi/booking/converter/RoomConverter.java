package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.CreateRoomDto;
import com.berezanskyi.booking.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter implements Converter<CreateRoomDto, Room> {
    @Override
    public Room convert(CreateRoomDto createRoomDto) {
        return Room.builder()
                .roomName(createRoomDto.getRoomName())
                .locationDescription(createRoomDto.getLocation_description())
                .numberOfSeats(createRoomDto.getNumber_of_seats())
                .projector(createRoomDto.getProjector())
                .phoneNumber(createRoomDto.getPhone_number())
                .build();
    }
}



