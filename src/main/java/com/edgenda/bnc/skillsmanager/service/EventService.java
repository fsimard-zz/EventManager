package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.service.exception.InvalidDataException;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownEventException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestService guestService;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @Transactional
    public Event createEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        return eventRepository.save(event);
    }

    @Transactional
    public void updateEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        eventRepository.save(event);
    }


    public Event getEventById(Long id){
        Assert.notNull(id, "Event ID cannot be null");
        return eventRepository.findById(id)
                .orElseThrow(() -> new UnknownEventException(id));
    }

    public List<Event> getEventsByGuestId(Long guestId) {
        Assert.notNull(guestId, "Guest ID cannot be null");
        return eventRepository.findByGuestId(guestId);
    }

   /* public List<Event> getEventsByOrganizerId(Long organizerID) {
        Assert.notNull(organizerID, "Guest ID cannot be null");
        return eventRepository.findByOrganisateur(organizerID);
    }
*/
    @Transactional
    public void deleteEvent(Long id){
        Assert.notNull(id, "ID cannot be null");
        eventRepository.delete(id);
    }

    @Transactional
    public void deleteCancelledEvent(Long id){
        Assert.notNull(id, "ID cannot be null");
        Event event = eventRepository.getOne(id);
        if(event == null){
            throw new UnknownEventException(id);
        } //TODO: check if event is cacelled or not
        else {
            eventRepository.delete(id);
        }
    }

    public List<Event> getEventsBetweenSpecificPeriod(LocalDateTime startTime, LocalDateTime endTime){
        if(startTime == null || endTime == null){
            throw new InvalidDataException("Request parameters are not valid");
        } else {
            //TODO: get list from event repo
        }
        return null;
    }

    public Event addEventToGuest(Long guestId, Long eventID){

        Guest existingGuest = guestService.getGuestById(guestId);
        Event existingEvent = getEventById(eventID);

        if(existingGuest != null && existingEvent != null){
            existingEvent.setGuests(Arrays.asList(existingGuest));
            return eventRepository.save(existingEvent);
        }
        return null;
    }



}
