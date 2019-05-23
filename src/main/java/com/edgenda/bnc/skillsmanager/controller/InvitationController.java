package com.edgenda.bnc.skillsmanager.controller;


import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/invitation")
public class InvitationController {

    private final InvitationService is;

    @Autowired
    public InvitationController(InvitationService is) {
        this.is = is;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Invitation> getAllInvitation(){
        return is.getAllInvitation();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Invitation createInvitation(@RequestBody Invitation invitation){
        return is.createInvitation(invitation);
    }

    @RequestMapping(path = "/id", method = RequestMethod.PUT)
    public void updateInvitation (@RequestBody Invitation invitation){
        is.updateInvitation(invitation);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Invitation getInvitation(@PathVariable Long id){
        return is.getInvitationById(id);
    }

//    @RequestMapping(path = "/{id}/event", method = RequestMethod.GET)
//    public List<Invitation> getGuestsByEvent(@PathVariable Long eventId){
//        return is.getInviByEventId(eventId);
//    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public void deleteInvitation(@PathVariable long id){
        is.deleteInvitation(id);
    }
}
