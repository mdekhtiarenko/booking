package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.CreateUpdateUserDto;
import com.berezanskyi.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<CreateUpdateUserDto, User>{

    @Override
    public User convert(CreateUpdateUserDto createUpdateUserDto) {
        return User.builder()
                .firstName(createUpdateUserDto.getFirstName())
                .surname(createUpdateUserDto.getSurname())
                .login(createUpdateUserDto.getLogin())
                .password(createUpdateUserDto.getPassword())
                .build();
    }
}
