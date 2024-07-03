package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFirstName {

    @NotBlank(message = "First name cannot be blank")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

}
