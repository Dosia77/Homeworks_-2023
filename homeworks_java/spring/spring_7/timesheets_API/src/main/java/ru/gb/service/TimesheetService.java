package ru.gb.service;

import org.springframework.stereotype.Service;
import ru.gb.model.Project;
import ru.gb.model.Timesheet;
import ru.gb.repository.ProjectRepository;
import ru.gb.repository.TimesheetRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {

    private final TimesheetRepository repository;
    private final ProjectRepository projectRepository;

    public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public Optional<Timesheet> findById(Long id) {
        return repository.findById(id);
    }

    public List<Timesheet> findByProjectId(Long projectId) {
        return repository.findByProjectId(projectId);
    }


    public List<Timesheet> getAll() {
        return repository.findAll();
    }

    public Timesheet create(Timesheet timesheet) {

        Optional<Project> ps = projectRepository.findById(timesheet.getProjectId());

            if (ps.isPresent()) {
                return repository.save(timesheet);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    

}
