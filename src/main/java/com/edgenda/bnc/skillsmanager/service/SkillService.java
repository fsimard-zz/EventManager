package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Employee;
import com.edgenda.bnc.skillsmanager.model.Skill;
import com.edgenda.bnc.skillsmanager.repository.EmployeeRepository;
import com.edgenda.bnc.skillsmanager.repository.SkillRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownSkillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository, EmployeeRepository employeeRepository) {
        this.skillRepository = skillRepository;
        this.employeeRepository = employeeRepository;
    }

    public Skill getSkill(Long id) {
        Assert.notNull(id, "Skill ID cannot be null");
        return skillRepository.findById(id)
                .orElseThrow(() -> new UnknownSkillException(id));
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public List<Employee> getEmployeesWithSkill(Long skillId) {
        Assert.notNull(skillId, "Skill ID cannot be null");
        return employeeRepository.findBySkillId(skillId);
    }
}

