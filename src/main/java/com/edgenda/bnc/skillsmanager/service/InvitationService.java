package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.repository.InvitationRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownInvitationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class InvitationService {

    @Autowired
    private InvitationRepository invitationRepository;

    public List<Invitation> getAllInvitation() {
        return invitationRepository.findAll();
    }

    public Invitation createInvitation(Invitation invitation) {
        Assert.notNull(invitation, "Invitation cannot be null");
        return invitationRepository.save(invitation);
    }

    public void updateInvitation(Invitation invitation) {
        Assert.notNull(invitation, "Invitation cannot be null");
        invitationRepository.save(invitation);
    }

    public Invitation getInvitationById(Long id){
        Assert.notNull(id, "id cannot be null");
        return invitationRepository.findById(id)
                .orElseThrow(() -> new UnknownInvitationException(id));
    }

    public void deleteInvitation(Long id){
        Assert.notNull(id, "Id cannot be null");
        invitationRepository.delete(id);
    }


}
