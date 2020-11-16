package com.berezanskyi.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateRoomDto {
    private String roomName;
    private String location_description;
    private Integer number_of_seats;
    private Boolean projector;
    private String phone_number;
}
