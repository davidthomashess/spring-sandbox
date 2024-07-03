package com.sandbox.company.update;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentAssignmentDate {

    @NotNull(message = "Assignment date cannot be blank")
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;

}