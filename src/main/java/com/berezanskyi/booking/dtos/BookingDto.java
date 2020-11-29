package com.berezanskyi.booking.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private EmbeddableUserDto user;
    private EmbeddableRoomDto room;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") // теж я б обгорнув в окрему аннотацію бо я помічав таку проблему
    // що коли працюють декілька людей над одним проектом може трапитися така штука що у різних ендпоінтів буде
    // різний формат дати якщо це не обговорити. Тому краще один раз зробити загалюну на проект і кожен раз не мучитися
    private Calendar startDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar endDateTime;
}
