package com.sandbox.company.entity;

import java.io.Serializable;

import com.sandbox.company.validation.PhoneType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(PhoneNumberPK.class)
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(name = "employee_id")
    private Employee id;

    @Id
    @Size(max = 20, message = "Too many numbers in your phone number")
    @Column(name = "phone")
    private String phone;

    @PhoneType
    @NotBlank(message = "Phone type cannot be blank")
    @NonNull
    @Column(name = "type", nullable = false)
    private String phoneType;

    @NotBlank(message = "You must secify whether this is the primary phone number")
    @Column(name = "primary", nullable = false)
    private boolean primary;

}
