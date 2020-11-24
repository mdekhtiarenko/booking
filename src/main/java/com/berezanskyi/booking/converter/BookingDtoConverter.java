package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.BookingDto;
import com.berezanskyi.booking.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoConverter implements Converter<Booking, BookingDto> {
    @Autowired
    private EmbeddableUserDtoConverter embeddableUserDtoConverter;

    @Autowired
    private EmbeddableRoomDtoConverter embeddableRoomDtoConverter;


    @Override
    public BookingDto convert(Booking booking) {
        return BookingDto.builder()
                .id(booking.getId())
                .user(embeddableUserDtoConverter.convert(booking.getUser()))
                .room(embeddableRoomDtoConverter.convert(booking.getRoom()))
                .startDateTime(booking.getStartDateTime())
                .endDateTime(booking.getEndDateTime())
                .build();
    }
}
