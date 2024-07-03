package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEmail {

    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

}
