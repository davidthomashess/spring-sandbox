package com.sandbox.mariokart.service;

import java.util.List;

import com.sandbox.mariokart.entity.Rank;

public interface RankService {

    List<Rank> getRanks();

    List<Rank> getPlayerRanks(Long playerId);

    List<Rank> getTrakRanks(Long trackId);

    Rank getRank(Long playerId, Long trackId);

    Rank saveRank(Rank rank, Long playerId, Long trackId);

    Rank updateRank(String placement, Long playerId, Long trackId);

    void deleteRank(Long playerId, Long trackId);

}
