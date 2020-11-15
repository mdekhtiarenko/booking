package com.berezanskyi.booking.dtos;

import com.berezanskyi.booking.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomDto {
    private String roomName;
    private String location_description;
    private Integer number_of_seats;
    private Boolean projector;
    private String phone_number;
}
