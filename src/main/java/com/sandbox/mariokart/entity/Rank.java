package com.sandbox.mariokart.entity;

// import com.sandbox.mariokart.validation.Placement;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;
// import lombok.*;

// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "rank", uniqueConstraints = {
//         @UniqueConstraint(columnNames = { "player_id", "track_id" })
// })
// public class Rank {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "rank_id")
//     private Long id;

//     @Placement
//     @Column(name = "placement", nullable = false)
//     private String placement;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "player_id")
//     private Player player;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "track_id")
//     private Track track;

// }

import com.sandbox.mariokart.validation.Placement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@IdClass(RankPK.class)
public class Rank {

    @Placement
    @Column(name = "placement", nullable = false)
    private String placement;

    @ManyToOne(optional = false)
    @Id
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(optional = false)
    @Id
    @JoinColumn(name = "track_id")
    private Track track;

}