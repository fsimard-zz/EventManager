package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.repository.EmployeeRepository;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.repository.GuestRepository;
import com.edgenda.bnc.skillsmanager.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final EventRepository eventRepository;


    @Autowired
    public GuestService(GuestRepository guestRepository, EventRepository eventRepository) {
        this.guestRepository = guestRepository;
        this.eventRepository = eventRepository;
    }

}
