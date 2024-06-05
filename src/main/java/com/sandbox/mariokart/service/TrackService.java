package com.sandbox.mariokart.service;

import java.util.List;
import java.util.Set;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;

public interface TrackService {

    List<Track> getTracks();

    Set<Player> getPlayersByTrack(Long id);

    Track getTrack(Long id);

    Track saveTrack(Track track);

    void deleteTrack(Long id);

    Track addPlayerToTrack(Long playerId, Long trackId);

}
