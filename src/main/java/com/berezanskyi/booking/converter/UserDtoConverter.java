package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.UserDto;
import com.berezanskyi.booking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserDtoConverter implements Converter<User, UserDto> {
    @Autowired
    private BookingDtoConverter bookingDtoConverter;


    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .login(user.getLogin())
                .bookings(bookingDtoConverter.convertAll(user.getBookings()))
                .build();
    }
}
