package com.edgenda.bnc.skillsmanager.controller;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService es;

    @Autowired
    public EventController(EventService es) {
        this.es = es;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return es.getAllEvents();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id) { return es.getEventById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return es.createEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateEvent(@PathVariable Long id, @RequestBody Event event) {
        es.updateEvent(
                new Event()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable Long id) {
        es.deleteEvent(id);
    }

    @RequestMapping(path = "/{id}/guest", method = RequestMethod.GET)
    public List<Event> getEventGuest(@PathVariable Long id) {
        return es.getEventsByGuestId(id);
    }


//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Event addGuestEvent(@RequestBody Event event) {
//        return es.createEvent(event);
//    }

}
