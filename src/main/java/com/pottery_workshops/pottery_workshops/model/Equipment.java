package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "equipment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO: on diagram it's enum, but should it be?
    @NotBlank(message = "name is mandatory")
    private String name;

    @Transient
    public boolean getIsReserved() {
        return checkIfReserved(LocalDate.now(), LocalTime.now());
    }

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Reservation> reservations = new HashSet<>();

    //TODO: how to implement many to many
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Studio> studios = new HashSet<>();

    private boolean checkIfReserved(LocalDate inDate, LocalTime inStartHour) {
        //TODO: here or service
        return false;
    }
}
