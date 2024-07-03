package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeState {

    @NotBlank(message = "State cannot be blank")
    @NonNull
    @Column(name = "state", nullable = false)
    private String state;

}
