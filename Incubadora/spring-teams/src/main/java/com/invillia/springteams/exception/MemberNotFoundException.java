package com.invillia.springteams.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(final String message) {
        super("Member ID " + message + " not found!");
    }
}
