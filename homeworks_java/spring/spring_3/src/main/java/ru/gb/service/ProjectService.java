package ru.gb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.gb.model.Project;
import ru.gb.repository.ProjectRepository;


@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    
    public Optional<Project> getById(Long id){
        return projectRepository.getById(id);
    }

    public List<Project> getAll(){
        return  projectRepository.getAll();
    }

    public Project create(Project project){
        return projectRepository.create(project);
    }

    public void delete(Long id){
        projectRepository.delete(id);
    }
    
}
