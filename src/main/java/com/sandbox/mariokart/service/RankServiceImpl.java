package com.sandbox.mariokart.service;

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
    public List<Rank> getPlayerRatings(Long playerId) {
        return rankRepository.findByPlayerId(playerId);
    }

    @Override
    public Rank getRank(Long playerId, Long trackId) {
        Optional<Rank> rank = rankRepository.findByPlayerIdAndTrackId(playerId, trackId);

        return unwrapRank(rank, playerId, trackId);
    }

    @Override
    public Rank saveRank(Rank rank, Long playerId, Long trackId) {
        Player player = PlayerServiceImpl.unwarpPlayer(playerRepository.findById(playerId), playerId);
        Track track = TrackServiceImpl.unwarpTrack(trackRepository.findById(trackId), trackId);

        if (!player.getTracks().contains(track))
            throw new PlayerWithoutTrackException(playerId, trackId);

        rank.setPlayer(player);
        rank.setTrack(track);

        return rankRepository.save(rank);
    }

    @Override
    public void deleteRank(Long playerId, Long trackId) {
        Optional<Rank> rank = rankRepository.findByPlayerIdAndTrackId(playerId, trackId);
    }

    static Rank unwarpRank(Optional<Rank> entity, Long playerId, Long trackId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new RankNotFoundException(playerId, trackId);
    }
}