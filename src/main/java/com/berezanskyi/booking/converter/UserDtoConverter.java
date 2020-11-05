package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.UserDto;
import com.berezanskyi.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .login(user.getLogin())
                .build();
    }
}
