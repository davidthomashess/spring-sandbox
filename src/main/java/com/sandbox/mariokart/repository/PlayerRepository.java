package com.sandbox.mariokart.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.mariokart.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
