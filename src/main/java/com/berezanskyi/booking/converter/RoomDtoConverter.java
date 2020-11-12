package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.RoomDto;
import com.berezanskyi.booking.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoConverter implements Converter<Room, RoomDto>{
    @Override
    public RoomDto convert(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .bookings(room.getBookings())
                .room_name(room.getRoom_name())
                .location_description(room.getLocation_description())
                .number_of_seats(room.getNumber_of_seats())
                .projector(room.getProjector())
                .phone_number(room.getPhone_number())
                .build();
    }
}

