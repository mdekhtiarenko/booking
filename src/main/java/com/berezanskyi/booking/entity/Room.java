package com.berezanskyi.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    @Column(nullable = false, length = 50, unique = true)
    private String room_name;

    @Column(length = 256)
    private String location_description;

    @Column(nullable = false, length = 100)
    private Integer number_of_seats;

    @Column(columnDefinition = "boolean default false")
    private Boolean projector;

    @Column(length = 100)
    private String phone_number;


}
