package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.CreateUpdateRoomDto;
import com.berezanskyi.booking.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter implements Converter<CreateUpdateRoomDto, Room> {
    @Override
    public Room convert(CreateUpdateRoomDto createUpdateRoomDto) {
        return Room.builder()
                .roomName(createUpdateRoomDto.getRoomName())
                .locationDescription(createUpdateRoomDto.getLocation_description())
                .numberOfSeats(createUpdateRoomDto.getNumber_of_seats())
                .projector(createUpdateRoomDto.getProjector())
                .phoneNumber(createUpdateRoomDto.getPhone_number())
                .build();
    }
}



