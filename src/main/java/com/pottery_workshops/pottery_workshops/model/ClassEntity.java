package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "class_entity")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "date is mandatory")
    private LocalDate date;

    @Column(name = "start_hour")
    @NotNull(message = "start hour is mandatory")
    private LocalTime startHour;

    @Column(name = "end_hour")
    @NotNull(message = "end hour is mandatory")
    private LocalTime endHour;

    @Column(name = "number_of_participants")
    @Min(1)
    private int numberOfParticipants;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "status is mandatory")
    private ClassEntityStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Course course;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Instructor> instructors = new HashSet<>();

    public enum ClassEntityStatus {
        MISSING_INSTRUCTOR,
        DRAFT,
        READY,
        OFFERING,
        POSTPONED,
        COMPLETED,
        CANCELED
    }
}
