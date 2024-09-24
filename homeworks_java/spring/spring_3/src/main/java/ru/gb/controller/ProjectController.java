package ru.gb.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.model.Project;
import ru.gb.model.Timesheet;
import ru.gb.service.ProjectService;
import ru.gb.service.TimesheetService;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private  final ProjectService projectService;
    private  final TimesheetService timesheetService;

    public ProjectController(ProjectService projectService, TimesheetService timesheetService){
        this.projectService = projectService;
        this.timesheetService = timesheetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Long id){
        Optional<Project> ts = projectService.getById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/timesheets")
    public ResponseEntity<Timesheet> getTimesheet(@PathVariable Long id){
        Optional<Project> ps = projectService.getById(id);
        Optional<Timesheet> ts = timesheetService.getByProjectId(id);

       if(ps.isPresent()){

          if(ts.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
          }

      }

       return  ResponseEntity.notFound().build();
    }
       
    @GetMapping
    public ResponseEntity<List<Project>>getAll(){
       return ResponseEntity.ok(projectService.getAll());
    }

  @PostMapping
  public ResponseEntity<Project>  create(@RequestBody Project project){
    project = projectService.create(project);

    return ResponseEntity.status(HttpStatus.CREATED).body(project);
}

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    projectService.delete(id);

    return ResponseEntity.noContent().build();
    }
   
}
