package com.sandbox.company.update;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStartDate {

    @NotNull(message = "You must provide a start date")
    @NonNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

}
