package com.edgenda.bnc.skillsmanager.service.exception;

public class UnknownGuestException extends RuntimeException {

    public UnknownGuestException(Long id) {
        super("Unknown Guests with ID=" + id);
    }
}
