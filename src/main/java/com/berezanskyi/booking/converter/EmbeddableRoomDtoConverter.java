package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.EmbeddableRoomDto;
import com.berezanskyi.booking.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class EmbeddableRoomDtoConverter implements Converter<Room, EmbeddableRoomDto> {
    @Override
    public EmbeddableRoomDto convert(Room room) {
        return EmbeddableRoomDto.builder()
                .id(room.getId())
                .room_name(room.getRoomName())
                .location_description(room.getLocationDescription())
                .number_of_seats(room.getNumberOfSeats())
                .projector(room.getProjector())
                .phone_number(room.getPhoneNumber())
                .build();
    }
}
