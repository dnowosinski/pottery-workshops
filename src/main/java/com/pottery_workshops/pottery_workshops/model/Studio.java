package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;
import java.util.*;

@Entity(name = "studio")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Studio {

    @Getter
    @Setter
    private static LocalTime openingTime = LocalTime.of(13,00);

    @Getter
    @Setter
    private static LocalTime closingTime = LocalTime.of(21,00);

    @Getter
    @Setter
    @Min(0)
    private static double membershipPrice = 0.00; //TODO: how to do class attr?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "address is mandatory")
    private Address address;

    @Column(name = "phone_number")
    @NotBlank(message = "phone number is mandatory")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "studio_course")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Course> courses = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "studio_equipment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Equipment> equipments = new HashSet<>(); //TODO: here on diagram is many to many, should it be? or one to many?

    @OneToMany(mappedBy = "studio")
    @MapKey(name = "peselNumber")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Map<String, Employee> employees = new HashMap<>();

    @OneToMany(mappedBy = "studio")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Material> materials = new HashSet<>();

    @OneToMany(mappedBy = "studio")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Product> products = new HashSet<>();
}
