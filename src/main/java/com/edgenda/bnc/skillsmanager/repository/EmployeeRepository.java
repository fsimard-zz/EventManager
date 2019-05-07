package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Employee, Long> {

    Optional<Guest> findById(Long id);

    @Query("SELECT guest FROM Gest employee JOIN guest.skills skill WHERE skill.id = ?1")
    List<Employee> findBySkillId(Long skillId);

}
