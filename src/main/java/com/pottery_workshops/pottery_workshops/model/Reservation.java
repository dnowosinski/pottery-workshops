package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    @NotNull(message = "start date is mandatory")
    private LocalDate startDate;

    @Column(name = "start_hour")
    @NotNull(message = "start hour is mandatory")
    private LocalTime startHour;

    @Min(1)
    private int time;

    @Transient
    public LocalTime getEndHour() {
        return startHour.plusMinutes(time);
    }

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull
    private Person person;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    @NotNull
    private Equipment equipment;

}
