package com.sandbox.mariokart.service;

import java.util.List;
import java.util.Set;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;

public interface PlayerService {

    List<Player> getPlayers();

    Set<Track> getTracksByPlayer(Long id);

    Player getPlayer(Long id);

    Player savePlayer(Player player);

    void deletePlayer(Long id);

}
