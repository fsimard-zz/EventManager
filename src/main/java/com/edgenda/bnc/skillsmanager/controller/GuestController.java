package com.edgenda.bnc.skillsmanager.controller;


import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.service.GuestService;
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
@RequestMapping(path = "/guests")
public class GuestController {

    private final GuestService gs;

    @Autowired
    public GuestController(GuestService es) {
        this.gs = es;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Guest> getAllGuest(){
        return gs.getAllGuest();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest){
        return gs.createGuest(guest);
    }

    @RequestMapping(path = "/id", method = RequestMethod.PUT)
    public void updateGuest (@RequestBody Guest guest){
        gs.updateGuest(guest);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Guest getGuest(@PathVariable Long id){
        return gs.getGuestById(id);
    }

    @RequestMapping(path = "/{id}/event", method = RequestMethod.GET)
    public List<Guest> getGuestsByEvent(@PathVariable Long eventId){
        return gs.getGuestsByEventId(eventId);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public void deleteGuest(@PathVariable long id){
        gs.deleteGuest(id);
    }
}
