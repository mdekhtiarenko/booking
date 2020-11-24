package com.berezanskyi.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddableRoomDto {
    private Long id;
    private String room_name;
    private String location_description;
    private Integer number_of_seats;
    private Boolean projector;
    private String phone_number;
}
