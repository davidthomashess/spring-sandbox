package com.sandbox.mariokart.web;

import java.util.List;

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

import com.sandbox.mariokart.entity.Rank;
import com.sandbox.mariokart.service.RankService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/rank")
public class RankController {

    private RankService rankService;

    @GetMapping("/all")
    public ResponseEntity<List<Rank>> getRanks() {
        return new ResponseEntity<>(rankService.getRanks(), HttpStatus.OK);
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<List<Rank>> getTrackRanks(@PathVariable Long trackId) {
        return new ResponseEntity<>(rankService.getTrackRanks(trackId), HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Rank>> getPlayerRanks(@PathVariable Long playerId) {
        return new ResponseEntity<>(rankService.getPlayerRanks(playerId), HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}/track/{trackId}")
    public ResponseEntity<Rank> getRank(@PathVariable Long playerId, @PathVariable Long trackId) {
        return new ResponseEntity<>(rankService.getRank(playerId, trackId), HttpStatus.OK);
    }

    @PostMapping("/player/{playerId}/track/{trackId}")
    public ResponseEntity<Rank> saveRank(@Valid @RequestBody Rank rank, @PathVariable Long playerId,
            @PathVariable Long trackId) {
        return new ResponseEntity<>(rankService.saveRank(rank, playerId, trackId), HttpStatus.CREATED);
    }

    @PutMapping("/player/{playerId}/track/{trackId}")
    public ResponseEntity<Rank> updateRank(@Valid @RequestBody Rank rank, @PathVariable Long playerId,
            @PathVariable Long trackId) {
        return new ResponseEntity<>(rankService.updateRank(rank.getPlacement(), playerId, trackId), HttpStatus.OK);
    }

    @DeleteMapping("/player/{playerId}/track/{trackId}")
    public ResponseEntity<HttpStatus> deleteRank(@PathVariable Long playerId, @PathVariable Long trackId) {
        rankService.deleteRank(playerId, trackId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
