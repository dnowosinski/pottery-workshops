package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Entity(name = "potter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Potter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "products_offered_in_current_month")
    @Transient
    public int productsOfferedInCurrentMonth() {
        return calculateProductsOfferedThisMonth();
    }

    @Column(name = "percentage_of_sold_procuts_this_month")
    @Transient
    public double percentageOfSoldProcutsThisMonth() {
        return calculatePercentageOfSoldProcutsThisMonth();
    }

    @OneToMany(mappedBy = "potter")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Product> products = new HashSet<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_pesel_number", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

    private int calculateProductsOfferedThisMonth() {
        return 0; //TODO
    }

    private double calculatePercentageOfSoldProcutsThisMonth() {
        return 0;
    }
}
