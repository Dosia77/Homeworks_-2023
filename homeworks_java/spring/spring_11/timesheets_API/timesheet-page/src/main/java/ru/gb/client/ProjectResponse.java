package ru.gb.client;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data
public class ProjectResponse {

  private Long id;
  private String name;


  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;

  }
}
