package com.pottery_workshops.pottery_workshops.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "category is mandatory")
    private Category category;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "status is mandatory")
    private Status status;

    private double price; //TODO: no annotations, check in db (and two attrs beneath)

    @Column(name = "date_of_creating_offer")
    private LocalDate dateOfCreatingOffer;

    @Column(name = "date_of_offer_completion")
    private LocalDate dateOfOfferCompletion;

    @Transient //TODO: please check all transients!
    public Set<Material> getUsedMaterials() {
        return null; //TODO: logic
    }

    @ManyToOne
    @JoinColumn(name = "potter_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Potter potter;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Studio studio;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Material> materials = new HashSet<>(); //TODO: here on diagram is Many to one, we should change it

    public Product(String name, Category category, Status status) {
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public enum Category {
        BOWL,
        CUP,
        MUG,
        VASE,
        COASTER,
        PLATE
    };

    public enum Status {
        FOR_FIRING,
        BISCUIT,
        READY_TO_SALE,
        FOR_SALE,
        SOLD,
        WITHDRAWN
    };
}
