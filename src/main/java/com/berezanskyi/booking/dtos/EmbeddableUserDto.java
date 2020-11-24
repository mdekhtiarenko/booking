package com.berezanskyi.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddableUserDto {
    private Long id;
    private String firstName;
    private String surname;
    private String login;
}
