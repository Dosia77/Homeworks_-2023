package ru.gb.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.client.ProjectResponse;
import ru.gb.service.ProjectPageService;


@Controller
@RequestMapping("/projects")
public class ProjectPageController {

    private final ProjectPageService service;

    public ProjectPageController(ProjectPageService service){
        this.service = service;
       
    }

    @GetMapping
    public String getAllProjects(Model model){
       List<ProjectResponse> projects = service.findAll();
        model.addAttribute("projects", projects);
    
        return "projects-page.html";

    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {

        Optional<ProjectResponse> projectOpt = service.findById(id);
        if(projectOpt.isEmpty()){
            throw new NoSuchElementException();
        }

        model.addAttribute("project", projectOpt.get());
         return "project-page.html";

    }

   
}
