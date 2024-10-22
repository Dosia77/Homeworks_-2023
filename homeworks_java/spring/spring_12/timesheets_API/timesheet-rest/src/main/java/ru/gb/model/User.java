package ru.gb.model;

import jakarta.persistence.*;
//import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name =  "\"user\"")
public class User {



  @Basic
  @Column(name = "login")
  private String login;

  @Basic
  @Column(name = "password")
  private String password;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;


  @ManyToMany(fetch = FetchType.EAGER)//(cascade = CascadeType.ALL)
  @JoinTable(name = "users_roles",
          //foreign key for EmployeeEntity in employee_car table
          joinColumns = @JoinColumn(name = "user_id"),
          //foreign key for other side - EmployeeEntity in employee_car table
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public Set<Role> getRole () {
    return roles;
  }

  public void setRoles(HashSet<Role> roles) {
    this.roles = roles;
  }

  public void addRole(Role role) {
    roles.add(role);
  }
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

//  @Override
//  public String toString() {
//    return "User{" +
//            "id=" + id +
//            ", login='" + login + '\'' +
//            ", password='" + password + '\'' +
//            ", roles=" + roles +
//            '}';
//  }
}
