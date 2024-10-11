package ru.gb.service;

import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.gb.aspect.Recover;
import ru.gb.aspect.Timer;
import ru.gb.model.Project;
import ru.gb.model.Timesheet;
import ru.gb.repository.ProjectRepository;
import ru.gb.repository.TimesheetRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Timer(level = Level.TRACE)
//@Recover(level = Level.TRACE)
public class TimesheetService {

    private final TimesheetRepository repository;
    private final ProjectRepository projectRepository;

    public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

   @Recover(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class, MethodArgumentTypeMismatchException.class})
    public Optional<Timesheet> findById(Long id) {

            return repository.findById(id);
    }


    public List<Timesheet> findByProjectId(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    @Recover(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class, MethodArgumentTypeMismatchException.class })
    @Timer(enabled = false)
    public List<Timesheet> findAll() {
        return repository.findAll();
    }


  @Recover(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class, MethodArgumentTypeMismatchException.class, MethodArgumentTypeMismatchException.class })
    public Timesheet create(Timesheet timesheet) {

        Optional<Project> ps = projectRepository.findById(timesheet.getProjectId());

            if (ps.isPresent()) {
                return repository.save(timesheet);
        }
        return null;
    }

    @Recover(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class})
    public void delete(Long id) {
        repository.deleteById(id);
    }

    

}
