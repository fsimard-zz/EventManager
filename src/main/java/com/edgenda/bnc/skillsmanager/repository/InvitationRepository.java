package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long>, CrudRepository<Invitation, Long> {

    Optional<Invitation> findById(Long id);

//    @Query("SELECT guest FROM Guest guest JOIN guest.events events WHERE events.id = ?1")
//    List<Guest> findByEventId(Long eventid);

}
