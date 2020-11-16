package com.berezanskyi.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String roomName;

    @Column(length = 256)
    private String locationDescription;

    @Column(nullable = false, length = 100)
    private Integer numberOfSeats;

    @Column(columnDefinition = "boolean default false")
    private Boolean projector;

    @Column(length = 100)
    private String phoneNumber;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

}
