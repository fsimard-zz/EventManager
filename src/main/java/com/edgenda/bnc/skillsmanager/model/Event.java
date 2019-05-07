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

    @NotEmpty
    private Boolean isCancelled;

    @NotEmpty
    private String Organizer;

    @ManyToMany
    @JoinTable(name = "GUEST_LIST")
    private List<Guest> guests;

    public Event() {
    }

    public Event(Long id, String name, String description, LocalDateTime startDate,LocalDateTime EndDate, String organizer, String Location, List<Guest> guests,Boolean iscancelled) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guests = guests;
        this.startDate = startDate;
        this.EndDate = EndDate;
        this.Location = Location;
        this.Organizer=organizer;
        this.isCancelled=iscancelled;
    }

    @PersistenceConstructor
    public Event(String name, String description, int Duration, String organizer, String Location, List<Guest> guests, Boolean iscancelled) {
        this.name = name;
        this.description = description;
        this.guests = guests;
        this.startDate = startDate;
        this.EndDate = EndDate;
        this.Organizer=organizer;
        this.Location = Location;
        this.isCancelled=iscancelled;
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


    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
    }
}
