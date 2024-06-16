package com.sandbox.company.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(AssignmentPK.class)
@Table(name = "assignment", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "employee_id", "project_id" })
})
public class Assignment {

    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(name = "project_id")
    private Project project;

    @NotBlank(message = "Assignment date cannot be blank")
    @NonNull
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;

}
