package com.edgenda.bnc.skillsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findById(Long id);

    @Query("SELECT skill FROM Skill skill JOIN skill.employees employee WHERE employee.id = ?1")
    List<Skill> findByEmployeeId(Long employeeId);

}
