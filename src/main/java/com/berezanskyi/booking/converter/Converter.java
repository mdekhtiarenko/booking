package com.berezanskyi.booking.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<FROM, TO> {

    TO convert(FROM from);

    default List<TO> convertAll(List<FROM> list) {
        return list.stream().map(this::convert).collect(Collectors.toList());
    }
}
