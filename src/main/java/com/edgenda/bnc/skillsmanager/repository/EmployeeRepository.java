package com.edgenda.bnc.skillsmanager.repository;

import java.util.List;
import java.util.Optional;

import com.edgenda.bnc.skillsmanager.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

    @Query("SELECT guest FROM Gest employee JOIN guest.skills skill WHERE skill.id = ?1")
    List<Employee> findBySkillId(Long skillId);

}
