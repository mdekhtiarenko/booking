package com.berezanskyi.booking.converter;

import com.berezanskyi.booking.dtos.EmbeddableUserDto;
import com.berezanskyi.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class EmbeddableUserDtoConverter implements Converter<User, EmbeddableUserDto> {
    @Override
    public EmbeddableUserDto convert(User user) {
        return EmbeddableUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .login(user.getLogin())
                .build();
    }
}
