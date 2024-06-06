package com.sandbox.mariokart.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.exception.DeleteException;
import com.sandbox.mariokart.exception.PlayerNotFoundException;
import com.sandbox.mariokart.repository.PlayerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Set<Track> getTracksByPlayer(Long id) {
        Player player = getPlayer(id);

        return player.getTracks();
    }

    @Override
    public Player getPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        return unwrapPlayer(player, id);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent())
            playerRepository.deleteById(id);
        else
            throw new DeleteException();
    }

    static Player unwrapPlayer(Optional<Player> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new PlayerNotFoundException(id);
    }

}
