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
                .location_description(createRoomDto.getLocation_description())
                .number_of_seats(createRoomDto.getNumber_of_seats())
                .projector(createRoomDto.getProjector())
                .phone_number(createRoomDto.getPhone_number())
                .build();
    }
}



