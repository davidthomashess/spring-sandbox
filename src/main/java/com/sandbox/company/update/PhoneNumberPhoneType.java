package com.sandbox.company.update;

import com.sandbox.company.validation.PhoneType;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberPhoneType {

    @Size(max = 20, message = "Too many numbers in your phone number")
    @NotBlank(message = "Phone type cannot be blank")
    @Column(name = "phone")
    private String phone;

    @PhoneType
    @NotBlank(message = "Phone type cannot be blank")
    @NonNull
    @Column(name = "phone_type", nullable = false)
    private String phoneType;

}
