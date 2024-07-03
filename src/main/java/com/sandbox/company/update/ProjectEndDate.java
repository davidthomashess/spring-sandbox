package com.sandbox.company.update;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEndDate {

    @NotNull(message = "You must provide a end date")
    @NonNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

}
