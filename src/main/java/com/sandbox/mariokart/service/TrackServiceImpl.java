package com.sandbox.mariokart.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.exception.DeleteException;
import com.sandbox.mariokart.exception.PlayerDataIntegrityException;
import com.sandbox.mariokart.exception.TrackNotFoundException;
import com.sandbox.mariokart.repository.PlayerRepository;
import com.sandbox.mariokart.repository.TrackRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    private PlayerRepository playerRepository;

    @Override
    public List<Track> getTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Set<Player> getPlayersByTrack(Long id) {
        Track track = getTrack(id);

        return track.getPlayers();
    }

    @Override
    public Track getTrack(Long id) {
        Optional<Track> track = trackRepository.findById(id);

        return unwrapTrack(track, id);
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void deleteTrack(Long id) {
        Optional<Track> track = trackRepository.findById(id);

        if (track.isPresent()) {
            trackRepository.deleteById(id);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public Track addPlayerToTrack(Long playerId, Long trackId) {
        Track track = getTrack(trackId);
        Set<Player> players = getPlayersByTrack(trackId);
        Optional<Player> player = playerRepository.findById(playerId);
        Player unwrappedPlayer = PlayerServiceImpl.unwrapPlayer(player, playerId);

        for (Player element : players) {
            if (element.getId().equals(playerId))
                throw new PlayerDataIntegrityException(playerId, trackId);
        }

        track.getPlayers().add(unwrappedPlayer);

        return trackRepository.save(track);
    }

    static Track unwrapTrack(Optional<Track> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new TrackNotFoundException(id);
    }

}
