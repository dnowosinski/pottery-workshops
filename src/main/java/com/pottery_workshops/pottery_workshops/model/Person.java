package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Size(max = 255)
    private String name;

    @NotBlank(message = "surname is mandatory")
    @Size(max = 255)
    private String surname;

    @NotBlank(message = "email is mandatory")
    private String email;

    @ElementCollection
    @CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "person_id"))
    @NotEmpty
    @Builder.Default
    private Set<String> phoneNumbers = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations;

    public Set<String> getPhoneNumbers() {
        return Collections.unmodifiableSet(phoneNumbers);
    }

}
