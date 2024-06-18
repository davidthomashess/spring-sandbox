package com.sandbox.mariokart.entity;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankPK implements Serializable {

    private Long player;
    private Long track;

}
