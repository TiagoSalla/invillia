package com.invillia.springteams.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(final String message) {
        super("Team ID " + message + " not found!");
    }
}
