package com.spring.employment.entity;

import com.spring.employment.validation.Score;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "employee_id", "employer_id" })
})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Score
    @Column(name = "rating", nullable = false)
    private String rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

}
