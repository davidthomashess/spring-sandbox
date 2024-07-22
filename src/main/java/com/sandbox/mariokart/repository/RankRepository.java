package com.sandbox.mariokart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.mariokart.entity.Rank;
import com.sandbox.mariokart.entity.RankPK;

import jakarta.transaction.Transactional;

public interface RankRepository extends CrudRepository<Rank, RankPK> {

    Optional<Rank> findByPlayerIdAndTrackId(Long playerId, Long trackId);

    @Transactional
    void deleteByPlayerIdAndTrackId(Long playerId, Long trackId);

    List<Rank> findByPlayerId(Long playerId);

    List<Rank> findByTrackId(Long trackId);

}