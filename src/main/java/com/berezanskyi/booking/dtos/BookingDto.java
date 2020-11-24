package com.berezanskyi.booking.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private EmbeddableUserDto user;
    private EmbeddableRoomDto room;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar startDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar endDateTime;
}
