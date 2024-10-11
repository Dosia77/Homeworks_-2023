package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Timesheet;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long>{

   List< Timesheet> findByProjectId(Long id);
}