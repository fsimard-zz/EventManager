package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, CrudRepository<Event, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event JOIN event.guests guests WHERE guests.id = ?1")
    List<Event> findByGuestId(Long guestId);

    @Query("SELECT event FROM Event event JOIN event.guests guests WHERE event.startDate >= ?1 AND event.endDate <= ?2")
    List<Event> findByPeriod(LocalDateTime startDate, LocalDateTime endDate);

}
