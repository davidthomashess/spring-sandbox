package com.sandbox.company.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Home address cannot be blank")
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "City cannot be blank")
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "state cannot be blank")
    @NonNull
    @Column(name = "state", nullable = false)
    private String state;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Column(name = "email", nullable = false)
    private String Email;

    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private HourlyEmployee hourlyEmployee;

    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private SalaryEmployee salaryEmployee;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Assignment> assignments;

}
