package com.sandbox.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary_employee")
public class SalaryEmployee {

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @NotBlank(message = "Hourly rate cannot be blank")
    @Column(name = "salary_rate", nullable = false, precision = 15, scale = 2)
    private double salaryRate;

    @NotBlank(message = "Must specify whether this is a full time employee")
    @Column(name = "full_time", nullable = false)
    private boolean fullTime;

}