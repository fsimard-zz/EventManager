package com.edgenda.bnc.skillsmanager.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;

    enum status {
        ACCEPT,
        PENDING,
        REJECT
    }

    @NotEmpty
    private String eventId;

    @NotEmpty
    private String guestId;

    @NotEmpty
    private int state;

    public Invitation() {
    }

    public Invitation(Long id, String eventId, String guestId, int status) {
        this.id = id;
        this.eventId = eventId;
        this.guestId = guestId;
        this.state = status;
    }

    @PersistenceConstructor
    public Invitation(String eventId, String guestId, int status) {
        this.eventId = eventId;
        this.guestId = guestId;
        this.state = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}