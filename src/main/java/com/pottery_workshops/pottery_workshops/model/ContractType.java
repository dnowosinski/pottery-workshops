package com.pottery_workshops.pottery_workshops.model;

import lombok.*;
import jakarta.persistence.*;

@Entity(name = "contract_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_pesel_number", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;


    /*
     --------------------------------------------
     * Here should be XOR between them
     TODO: how to implement it?
     */
    @OneToOne(mappedBy = "contractType", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Intern intern;

    @OneToOne(mappedBy = "contractType", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private FullTime fullTime;
    /*
     --------------------------------------------
     */

}
