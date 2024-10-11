package ru.gb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.gb.model.Project;
//import ru.gb.model.Timesheet;
//import ru.gb.repository.deprecated.ProjectRepository;
import ru.gb.repository.ProjectRepository;


@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){//}, TimesheetService tService){
        this.projectRepository = projectRepository;

    }

    
    public Optional<Project> findById(Long id){
        return projectRepository.findById(id);
    }

    public List<Project> getAll(){
        return  projectRepository.findAll();
    }

    public Project create(Project project){
        return projectRepository.save(project);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }

}
