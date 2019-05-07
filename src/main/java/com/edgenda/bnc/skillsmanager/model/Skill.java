package com.edgenda.bnc.skillsmanager.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @ManyToMany
    @JoinTable(name = "EMPLOYEES_SKILLS")
    private List<Employee> employees;

    public Skill() {
    }

    public Skill(Long id, String name, String description, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    @PersistenceConstructor
    public Skill(String name, String description, List<Employee> employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}