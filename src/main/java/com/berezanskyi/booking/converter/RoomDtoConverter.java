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
                .room_name(room.getRoomName())
                .location_description(room.getLocationDescription())
                .bookings(room.getBookings())
                .number_of_seats(room.getNumberOfSeats())
                .projector(room.getProjector())
                .phone_number(room.getPhoneNumber())
                .build();
    }
}

