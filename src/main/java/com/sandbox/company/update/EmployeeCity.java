package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCity {

    @NotBlank(message = "City cannot be blank")
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;

}
