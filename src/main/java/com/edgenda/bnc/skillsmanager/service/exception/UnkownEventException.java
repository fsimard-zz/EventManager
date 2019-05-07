package com.edgenda.bnc.skillsmanager.service.exception;

public class UnkownEventException extends RuntimeException {

    public UnkownEventException(Long id) {
        super("Unknown Event with ID=" + id);
    }
}
