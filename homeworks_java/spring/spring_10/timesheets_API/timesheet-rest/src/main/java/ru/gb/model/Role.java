package ru.gb.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  private Long id;

  @Column(name="role_name")
  private String name;

  @ManyToMany
  @JoinTable(name = "users_roles",
          //foreign key for EmployeeEntity in employee_car table
          joinColumns = @JoinColumn(name = "role_id"),
          //foreign key for other side - EmployeeEntity in employee_car table
          inverseJoinColumns = @JoinColumn(name = "user_id"))

  private Set<User> users = new HashSet<>();

  public Role(String name) {
    this.name = name;
  }

  public Role() {
  }


  public Set<User> getUser () {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public void addCar(User user) {
    users.add(user);
  }


  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  @Override
//  public String toString() {
//    return "Role{" +
//            "id=" + id +
//            ", name='" + name + '\'' +
//            ", users=" + users +
//            '}';
//  }
}
