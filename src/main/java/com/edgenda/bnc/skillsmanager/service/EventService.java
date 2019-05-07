package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownEventException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event createEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        return eventRepository.save(event);
    }

    public void updateEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        eventRepository.save(event);
    }

    public Event getEventById(Long id){
        Assert.notNull(id, "Event ID cannot be null");
        return eventRepository.findById(id)
                .orElseThrow(() -> new UnknownEventException(id));
    }

    public List<Event> getEventsByGuest(Long guestId) {
        return null;
    }

    public void deleteEvent(Long id){
        Assert.notNull(id, "ID cannot be null");
        eventRepository.delete(id);
    }



}
