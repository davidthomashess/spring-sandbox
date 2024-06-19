package com.sandbox.company.entity;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentPK implements Serializable {

    private Long employee;
    private Long project;

}
