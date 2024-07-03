package com.sandbox.company.update;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberPhonePrimary {

    @Size(max = 20, message = "Too many numbers in your phone number")
    @NotBlank(message = "Phone type cannot be blank")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "You must secify whether this is the primary phone number")
    @Column(name = "phone_primary", nullable = false)
    private boolean phonePrimary;

}
