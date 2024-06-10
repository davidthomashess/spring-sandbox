package com.sandbox.mariokart.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @NotBlank(message = "Track name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Difficulty cannot be blank")
    @NonNull
    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @NotBlank(message = "Info cannot be blank")
    @NonNull
    @Column(name = "info", nullable = false, length = 1200)
    private String info;

    @JsonIgnore
    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    private List<Rank> ranks;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "track_player", joinColumns = @JoinColumn(name = "track_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

}
