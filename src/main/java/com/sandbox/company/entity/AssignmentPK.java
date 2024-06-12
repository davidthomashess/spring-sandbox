package com.sandbox.company.entity;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class AssignmentPK implements Serializable {

    protected Employee employee;
    protected Project project;

}
