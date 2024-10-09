package ru.gb.page;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.model.Project;
import ru.gb.service.ProjectService;


@Controller
@RequestMapping("/home/projects")
public class ProjectPageController {

    private final ProjectService service;

    public ProjectPageController(ProjectService service){
        this.service = service;
       
    }

    @GetMapping
    public String getAllProjectss(Model model){
       List<Project> projects = service.getAll();
        model.addAttribute("projects", projects);
    
        return "projects-page.html";

    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {

        Optional<Project> projectOpt = service.findById(id);
        if(projectOpt.isEmpty()){
            throw new NoSuchElementException();
        }

        model.addAttribute("project", projectOpt.get());
         return "project-page.html";

    }

   
}
