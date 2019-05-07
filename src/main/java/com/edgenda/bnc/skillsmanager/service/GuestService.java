package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.repository.GuestRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownGuestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventService eventService;

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        return guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        guestRepository.save(guest);
    }

    public Guest getGuestById(Long id){
        Assert.notNull(id, "Guest Id cannot be null");
        return guestRepository.findById(id)
                .orElseThrow(() -> new UnknownGuestException(id));
    }

    public List<Guest> getGuestsByEventId(Long eventId) {
        return guestRepository.findByEventId(eventId);
    }

    public void deleteGuest(Long id){
        Assert.notNull(id, "Id cannot be null");
        guestRepository.delete(id);
    }





}
