package com.sandbox.company.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AssignmentPK implements Serializable {

    private Long employee;
    protected Long project;

    // public boolean equals(Object object) {
    // if (object instanceof PhonePK) {
    // PhonePK pk = (PhonePK)object;
    // return type.equals(pk.type) && owner == pk.owner;
    // } else {
    // return false;
    // }
    // }

    // public int hashCode() {
    // return (int)(type.hashCode() + owner);
    // }
}
