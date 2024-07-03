package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress {

    @NotBlank(message = "Home address cannot be blank")
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

}
