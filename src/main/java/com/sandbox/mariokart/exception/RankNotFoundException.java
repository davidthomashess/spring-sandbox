package com.sandbox.mariokart.exception;

public class RankNotFoundException extends RuntimeException {

    public RankNotFoundException(Long playerId, Long trackId) {
        super("The rank with player id: '" + playerId + "' and track id: '" + trackId
                + "' does not exist in our records");
    }

}
