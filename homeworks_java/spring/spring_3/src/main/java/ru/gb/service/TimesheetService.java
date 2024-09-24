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

    public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository){
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public Optional<Timesheet> getById(Long id){
        return repository.getById(id);
    }

    public Optional<Timesheet> getByProjectId(Long projectId){
        return repository.getByProjectId(projectId);
    }


    public List<Timesheet> getAll(){
        return  repository.getAll();
    }

    public Timesheet create(Timesheet timesheet){
        Optional<Project> ps = projectRepository.getById(timesheet.getProjectId());
        if(ps.isPresent()){       
           return repository.create(timesheet); 
        }  return null;        
    }

    public void delete(Long id){
        repository.delete(id);
    }
}
