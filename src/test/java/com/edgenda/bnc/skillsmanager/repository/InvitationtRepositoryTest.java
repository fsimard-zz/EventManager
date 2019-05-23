package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InvitationtRepositoryTest {

  @Autowired
  private InvitationRepository invitationRepository;

  @Test
  public void testFindById() {
    Optional<Invitation> invitation = invitationRepository.findById(1L);
    int n = 0;
  }
}
