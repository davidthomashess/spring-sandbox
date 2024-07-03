package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectName {

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

}
