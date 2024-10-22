package ru.gb.client;

import lombok.Data;

import java.time.LocalDate;

//@Data
public class TimesheetResponse {

  private Long id;
  private Long projectId;
  private Integer minutes;

  public Long getId() {
    return id;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public Integer getMinutes() {
    return minutes;
  }

  public void setMinutes(Integer minutes) {
    this.minutes = minutes;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  private LocalDate createdAt;

}