package com.berezanskyi.booking.dtos;


import com.berezanskyi.booking.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private List<Booking> bookings;
    private String room_name;
    private String location_description;
    private Integer number_of_seats;
    private Boolean projector;
    private String phone_number;
}
