package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.repository.GuestRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownGuestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final EventRepository eventRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, EventRepository eventRepository) {
        this.guestRepository = guestRepository;
        this.eventRepository = eventRepository;
    }

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        final Guest newGuest = new Guest(
                guest.getFirstName(),
                guest.getLastName(),
                guest.getEmail(),
                Collections.emptyList()
        );
        return guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        this.getGuest(guest.getId());
        guestRepository.save(guest);
    }

    public Guest getGuest(Long id){
        Assert.notNull(id, "Guest Id cannot be null");
        return guestRepository.findById(id)
                .orElseThrow(() -> new UnknownGuestException(id));
    }

    public List<Event> getGuestsByEvent(Long eventId) {
        return eventRepository.findByGuestId(eventId);
    }

    public void deleteGuest(Long id){
        Assert.notNull(id, "Id cannot be null");
        guestRepository.delete(id);
    }



}
