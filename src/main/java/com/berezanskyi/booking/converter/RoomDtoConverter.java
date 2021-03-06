package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.RoomDto;
import com.berezanskyi.booking.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoConverter implements Converter<Room, RoomDto>{
    @Autowired
    private BookingDtoConverter bookingDtoConverter;


    @Override
    public RoomDto convert(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .room_name(room.getRoomName())
                .location_description(room.getLocationDescription())
                .number_of_seats(room.getNumberOfSeats())
                .projector(room.getProjector())
                .phone_number(room.getPhoneNumber())
                .bookings(bookingDtoConverter.convertAll(room.getBookings()))
                .build();
    }
}

