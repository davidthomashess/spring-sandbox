package com.sandbox.company.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assignment", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "employee_id", "project_id" })
})
@Data
@IdClass(AssignmentPK.class)
public class Assignment {

    @ManyToOne(optional = false)
    @Id
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @Id
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull(message = "Assignment date cannot be blank")
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;

}
