package com.pottery_workshops.pottery_workshops.model;

import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "approved_courses")
    @ElementCollection
    @CollectionTable(name = "approved_courses", joinColumns = @JoinColumn(name = "instructor_id"))
    @Builder.Default
    @NotEmpty
    private Set<CourseName> approvedCourses = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "instructor_class_entity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<ClassEntity> classEntities = new HashSet<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_pesel_number", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

    public enum CourseName {}
}
