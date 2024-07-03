package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryEmployeeFullTime {

    @NotBlank(message = "Must specify whether this is a full time employee")
    @Column(name = "full_time", nullable = false)
    private boolean fullTime;

}
