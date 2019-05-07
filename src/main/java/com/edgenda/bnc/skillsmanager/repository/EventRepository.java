package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Skill, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event JOIN event.guests guests WHERE guest.id = ?1")
    List<Event> findByGuestId(Long guestId);

}
