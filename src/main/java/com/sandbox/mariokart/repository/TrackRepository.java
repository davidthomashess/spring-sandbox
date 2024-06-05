package com.sandbox.mariokart.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.mariokart.entity.Track;

public interface TrackRepository extends CrudRepository<Track, Long> {

}
