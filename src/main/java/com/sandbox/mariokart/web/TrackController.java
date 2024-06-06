package com.sandbox.mariokart.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.service.TrackService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/track")
public class TrackController {

    TrackService trackService;

    @GetMapping("/all")
    public ResponseEntity<List<Track>> getTracks() {
        return new ResponseEntity<>(trackService.getTracks(), HttpStatus.OK);
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<Set<Player>> getPlayersByTrack(@PathVariable Long id) {
        return new ResponseEntity<>(trackService.getPlayersByTrack(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrack(@PathVariable Long id) {
        return new ResponseEntity<>(trackService.getTrack(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Track> saveTrack(@Valid @RequestBody Track track) {
        return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{trackId}/player/{playerId}")
    public ResponseEntity<Track> addPlayerToTrack(@PathVariable Long trackId, @PathVariable Long playerId) {
        return new ResponseEntity<>(trackService.addPlayerToTrack(playerId, trackId), HttpStatus.OK);
    }

}
