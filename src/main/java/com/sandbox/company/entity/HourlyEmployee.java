package com.sandbox.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hourly_employee")
public class HourlyEmployee {

    @Id
    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "employee_id")
    private Long id;

    @NotBlank(message = "Hourly rate cannot be blank")
    @Column(name = "hourly_rate", nullable = false, precision = 7, scale = 2)
    private double hourlyRate;

    @NotBlank(message = "Must specify whether this is a full time employee")
    @Column(name = "full_time", nullable = false)
    private boolean fullTime;

}
