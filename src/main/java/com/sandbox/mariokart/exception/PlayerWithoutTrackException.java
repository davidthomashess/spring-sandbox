package com.sandbox.mariokart.exception;

public class PlayerWithoutTrackException extends RuntimeException {

    public PlayerWithoutTrackException(Long playerId, Long trackId) {
        super("The player with id: " + playerId + "' did not run on the track with id: '" + trackId);
    }

}
