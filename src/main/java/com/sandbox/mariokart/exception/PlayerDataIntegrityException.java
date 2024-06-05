package com.sandbox.mariokart.exception;

public class PlayerDataIntegrityException extends RuntimeException {

    public PlayerDataIntegrityException(Long playerId, Long trackId) {
        super("The player with id: '" + playerId + "' already ran on the trak with track id: '" + trackId);
    }

}
