package ru.gb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.HashSet;

@Entity
//@Data
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)

    private Long id;
    private String name;
    private String lastName;
    private HashSet<Long> projectsId;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Long> getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(HashSet<Long> projectsId) {
        this.projectsId = projectsId;
    }

}
