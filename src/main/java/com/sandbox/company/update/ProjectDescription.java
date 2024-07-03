package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDescription {

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

}
