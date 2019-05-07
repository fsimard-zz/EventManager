package com.edgenda.bnc.skillsmanager.service.exception;

public class UnkownGuestException extends RuntimeException {

    public UnkownGuestException(Long id) {
        super("Unknown Guest with ID=" + id);
    }
}
