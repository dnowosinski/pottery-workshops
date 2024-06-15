package com.pottery_workshops.pottery_workshops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "employee")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@SuperBuilder
public abstract class Employee extends Person {

    @Id
    @Column(name = "pesel_number")
    private String peselNumber;

    @Column(name = "bank_account_number")
    @NotBlank(message = "bank account number is mandatory")
    private String bankAccountNumber;

    @Column(name = "hourly_rate")
    @Min(0)
    private double hourlyRate;

    @Column(name = "date_of_employment")
    @NotNull(message = "bank account number is mandatory")
    private LocalDate dateOfEmployment;

    //TODO: check how to do transient
    @Transient
    public Double getSalary() {
        return calculateSalary();
    }

    @Transient
    public int getMonthsOfEmployment() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfEmployment, currentDate);
        return period.getYears() * 12 + period.getMonths();
    }

    @Transient
    public boolean getIsManager() {
        return !managedEmployees.isEmpty();
    }

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Studio studio;

    @OneToMany(mappedBy = "manager")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> isManagerOf = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_pesel_number") //TODO: check if here employee_id or pesel
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Member> members = new HashSet<>(); //TODO: Here this whole functionality of adding memebrs should be in Full-TIme class NOT employee!!

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //TODO: not null,
    // check how to do 1:1
    private ContractType contractType;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Instructor instructor;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Potter potter;

    public abstract double calculateSalary(); //TODO: here or service? (used in transient attr)

}
