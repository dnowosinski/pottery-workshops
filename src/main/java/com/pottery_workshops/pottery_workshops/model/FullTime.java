package com.pottery_workshops.pottery_workshops.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "full_time")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "benefits", joinColumns = @JoinColumn(name = "full_time_id"))
    @Builder.Default
    @Getter
    @Setter
    private static Set<Benefit> benefits = new HashSet<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "contract_type_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContractType contractType;

    public enum Benefit {}
}
