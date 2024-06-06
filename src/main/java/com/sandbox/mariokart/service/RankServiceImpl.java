package com.sandbox.mariokart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.mariokart.entity.Player;
import com.sandbox.mariokart.entity.Rank;
import com.sandbox.mariokart.entity.Track;
import com.sandbox.mariokart.exception.DeleteException;
import com.sandbox.mariokart.exception.PlayerWithoutTrackException;
import com.sandbox.mariokart.exception.RankNotFoundException;
import com.sandbox.mariokart.repository.PlayerRepository;
import com.sandbox.mariokart.repository.RankRepository;
import com.sandbox.mariokart.repository.TrackRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RankServiceImpl implements RankService {

    private PlayerRepository playerRepository;
    private RankRepository rankRepository;
    private TrackRepository trackRepository;

    @Override
    public List<Rank> getRanks() {
        return (List<Rank>) rankRepository.findAll();
    }

    @Override
    public List<Rank> getTrackRanks(Long trackId) {
        return rankRepository.findByTrackId(trackId);
    }

    @Override
    public List<Rank> getPlayerRanks(Long playerId) {
        return rankRepository.findByPlayerId(playerId);
    }

    @Override
    public Rank getRank(Long playerId, Long trackId) {
        Optional<Rank> rank = rankRepository.findByPlayerIdAndTrackId(playerId, trackId);

        return unwrapRank(rank, playerId, trackId);
    }

    @Override
    public Rank saveRank(Rank rank, Long playerId, Long trackId) {
        Player player = PlayerServiceImpl.unwrapPlayer(playerRepository.findById(playerId), playerId);
        Track track = TrackServiceImpl.unwrapTrack(trackRepository.findById(trackId), trackId);

        if (!player.getTracks().contains(track))
            throw new PlayerWithoutTrackException(playerId, trackId);

        rank.setPlayer(player);
        rank.setTrack(track);

        return rankRepository.save(rank);
    }

    @Override
    public Rank updateRank(String placement, Long playerId, Long trackId) {
        Optional<Rank> rank = rankRepository.findByPlayerIdAndTrackId(playerId, trackId);
        Rank unwrappedRank = unwrapRank(rank, playerId, trackId);

        unwrappedRank.setPlacement(placement);

        return rankRepository.save(unwrappedRank);
    }

    @Override
    public void deleteRank(Long playerId, Long trackId) {
        Optional<Rank> rank = rankRepository.findByPlayerIdAndTrackId(playerId, trackId);

        if (rank.isPresent()) {
            rankRepository.deleteByPlayerIdAndTrackId(playerId, trackId);
        } else {
            throw new DeleteException();
        }
    }

    static Rank unwrapRank(Optional<Rank> entity, Long playerId, Long trackId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new RankNotFoundException(playerId, trackId);
    }

}
