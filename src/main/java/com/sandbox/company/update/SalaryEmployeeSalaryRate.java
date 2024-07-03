package com.sandbox.company.update;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryEmployeeSalaryRate {

    @NotBlank(message = "Salary rate cannot be blank")
    @Column(name = "salary_rate", nullable = false, precision = 7, scale = 2)
    private BigDecimal salaryRate;

}
