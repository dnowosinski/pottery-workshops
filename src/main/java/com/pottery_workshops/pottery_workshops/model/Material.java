package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Struct;
import java.util.HashSet;


@Entity(name = "material")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name; //TODO: should be enum?

    @Min(0)
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Studio studio;

    @OneToMany(mappedBy = "material")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Product> products = new HashSet<>();

}
