package com.edgenda.bnc.skillsmanager.service.exception;

public class UnknownEventException extends RuntimeException {

    public UnknownEventException(Long id) {
        super("Unknown Event with ID=" + id);
    }
}
