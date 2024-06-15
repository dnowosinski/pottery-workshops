package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private static Double COURSE_DISCOUNT = 10d;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;


}
