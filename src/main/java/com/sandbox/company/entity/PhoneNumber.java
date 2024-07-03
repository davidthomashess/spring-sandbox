package com.sandbox.company.entity;

import java.io.Serializable;

import com.sandbox.company.validation.PhoneType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Size(max = 20, message = "Too many numbers in your phone number")
    @NotBlank(message = "Phone type cannot be blank")
    @Column(name = "phone")
    private String phone;

    @PhoneType
    @NotBlank(message = "Phone type cannot be blank")
    @NonNull
    @Column(name = "phone_type", nullable = false)
    private String phoneType;

    @NotBlank(message = "You must secify whether this is the primary phone number")
    @Column(name = "phone_primary", nullable = false)
    private boolean phonePrimary;

}
