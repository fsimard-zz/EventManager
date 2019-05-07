package com.edgenda.bnc.skillsmanager.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Organizer {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String Name;


    public Organizer(Long id, String name, String addresse, String phonenumber) {
        this.id = id;
        Name = name;
        this.addresse = addresse;
        this.phonenumber = phonenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @NotEmpty
    private String addresse;

    @NotEmpty
    private String phonenumber;
}
