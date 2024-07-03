package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLastName {

    @NotBlank(message = "Last name cannot be blank")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

}
