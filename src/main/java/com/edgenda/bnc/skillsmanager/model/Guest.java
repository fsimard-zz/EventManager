package com.edgenda.bnc.skillsmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @ManyToMany
    @JoinTable(name = "GUEST_EVENT")
    private List<Event> events;

    @ManyToMany
    @JoinTable(name = "INVITATION_GUEST_LIST")
    private List<Invitation> invitations;

    public Guest() {
    }

    public Guest(Long id, String firstName, String lastName, String email, List<Event> events, List<Invitation> invitations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
        this.invitations = invitations;
    }

    @PersistenceConstructor
    public Guest(String firstName, String lastName, String email, List<Event> events,  List<Invitation> invitations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
        this.invitations = invitations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }
}
