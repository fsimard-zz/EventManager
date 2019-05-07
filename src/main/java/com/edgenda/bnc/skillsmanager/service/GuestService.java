package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        guestRepository.save(guest);
    }

}
