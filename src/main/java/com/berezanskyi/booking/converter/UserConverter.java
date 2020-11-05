package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.CreateUserDto;
import com.berezanskyi.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<CreateUserDto, User>{

    @Override
    public User convert(CreateUserDto createUserDto) {
        return User.builder()
                .firstName(createUserDto.getFirstName())
                .surname(createUserDto.getSurname())
                .login(createUserDto.getLogin())
                .build();
    }
}
