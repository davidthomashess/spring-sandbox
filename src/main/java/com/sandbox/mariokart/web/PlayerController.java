package com.sandbox.mariokart.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.service.PlayerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getPlayers() {
        return new ResponseEntity<>(playerService.getPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{id}/tracks")
    public ResponseEntity<Set<Track>> getTracksByPlayer(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getTracksByPlayer(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getPlayer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@Valid @RequestBody Player player) {
        return new ResponseEntity<>(playerService.savePlayer(player), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
