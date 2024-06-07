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
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Allegiance cannot be blank")
    @NonNull
    @Column(name = "allegiance", nullable = false)
    private String allegiance;

    @JsonIgnore
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Rank> ranks;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "track_player", joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"))
    private Set<Track> tracks;

}
