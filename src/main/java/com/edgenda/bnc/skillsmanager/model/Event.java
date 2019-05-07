package com.edgenda.bnc.skillsmanager.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private LocalDateTime startDate;
    @NotEmpty
    private LocalDateTime EndDate;
    @NotEmpty
    private String Location;

    public Organizer getOrganisateur() {
        return Organisateur;
    }

    public void setOrganisateur(Organizer organisateur) {
        Organisateur = organisateur;
    }

    @NotEmpty
    private Organizer Organisateur;

    @ManyToMany
    @JoinTable(name = "GUEST_LIST")
    private List<Guest> guests;

    public Event() {
    }

    public Event(Long id, String name, String description, LocalDateTime startDate,LocalDateTime EndDate, String Objet, String Location, List<Guest> guests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guests = guests;
        this.startDate = startDate;
        this.EndDate = EndDate;
        this.Location = Location;

    }

    @PersistenceConstructor
    public Event(String name, String description, int Duration, String Objet, String Location, List<Guest> guests) {
        this.name = name;
        this.description = description;
        this.guests = guests;
        this.startDate = startDate;
        this.EndDate = EndDate;

        this.Location = Location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        EndDate = endDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
