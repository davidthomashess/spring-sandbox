package com.sandbox.company.entity;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberPK implements Serializable {

    protected Employee employee;
    protected String phone;

}
