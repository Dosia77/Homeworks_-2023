package ru.gb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.HashSet;

@Entity
//@Data
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    //@EqualsAndHashCode.Include
    private Long id;
    private String name;
    private HashSet<Long> employeesId;


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
    public HashSet<Long> getEmployeesId(){
        return employeesId;
    }

    public void setEmployeesId(HashSet<Long> employeesId){
       
        this.employeesId = employeesId;
    }

  
}
