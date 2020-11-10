package com.berezanskyi.booking.dtos;

import com.berezanskyi.booking.entity.Booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String surname;
    private String login;
    private List<Booking> bookings;
}
