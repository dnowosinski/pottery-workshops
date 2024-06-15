package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @Min(0)
    private double price;

    private String description; //TODO: check if nullable in database

    @Column(name = "max_participants")
    @Min(1)
    private int maxParticipants;

    //TODO: eq on diagram is Enum, so check if it can be enum or string
    @Column(name = "eq_needed_per_person")
    @Builder.Default
    private Set<String> eqNeededPerPerson = new HashSet<>();

    //TODO: mats on diagram is Enum, so check if it can be enum or string
    @Column(name = "mats_needed_per_person")
    @Builder.Default
    private Set<String> matsNeededPerPerson = new HashSet<>(); //TODO: mats are mandatory to have at least one, how to implement that?

    @Min(1)
    private int length;

    @Transient
    private double getMaxProfitPerHour()  {
        return ( 60 / length ) * price * maxParticipants;
    } //TODO: check how to do this atributes

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<ClassEntity> classEntities = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Studio> studios = new HashSet<>();

    public Course(String name, double price, int maxParticipants, Set<String> matsNeededPerPerson, int length) {
        this.name = name;
        this.price = price;
        this.maxParticipants = maxParticipants;
        this.matsNeededPerPerson = matsNeededPerPerson;
        this.length = length;
    }

    public Set<String> getEqNeededPerPerson() {
        return Collections.unmodifiableSet(eqNeededPerPerson);
    }

    public Set<String> getMatsNeededPerPerson() {
        return Collections.unmodifiableSet(matsNeededPerPerson);
    }
}
