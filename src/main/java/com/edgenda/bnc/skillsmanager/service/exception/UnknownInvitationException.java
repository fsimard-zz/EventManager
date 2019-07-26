package com.edgenda.bnc.skillsmanager.service.exception;

public class UnknownInvitationException extends RuntimeException {

    public UnknownInvitationException(Long id) {
        super("Unknown Invitation with ID=" + id);
    }
}
