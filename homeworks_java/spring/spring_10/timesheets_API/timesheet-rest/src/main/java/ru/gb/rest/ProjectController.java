package ru.gb.rest;

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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.gb.model.Employee;
import ru.gb.model.Project;
import ru.gb.model.Timesheet;
import ru.gb.service.ProjectService;
import ru.gb.service.TimesheetService;


@RestController
@RequestMapping("/projects")
@Tag(name="Projects", description="API для работы с проектами")
public class ProjectController {

    private  final ProjectService projectService;
    private  final TimesheetService timesheetService;

    public ProjectController(ProjectService projectService, TimesheetService timesheetService){
        this.projectService = projectService;
        this.timesheetService = timesheetService;
    }

    @Operation(summary= "Get project", description="Получить проект по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Long id){
        Optional<Project> ts = projectService.findById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }

    @Operation(summary= "Get project's timesheets", description="Получить рабочие записи к проекту по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping("/{id}/timesheets")
    public ResponseEntity<Timesheet> getTimesheet(@PathVariable Long id){
      
     Optional<Project> ps = projectService.findById(id);    
          Optional<Timesheet> ts = timesheetService.findById(id);
       if(ps.isPresent()){

          if(ts.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
          }

     }

       return  ResponseEntity.notFound().build();
    }
     
    @Operation(summary= "Get all projects", description="Получить список всех проектов",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping
    public ResponseEntity<List<Project>>findAll(){
       return ResponseEntity.ok(projectService.findAll());
    }

    @Operation(summary= "Post project", description="Добавить проект в список",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "201", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @PostMapping
    public ResponseEntity<Project>  create(@RequestBody Project project){
    project = projectService.create(project);

    return ResponseEntity.status(HttpStatus.CREATED).body(project);
}

    @Operation(summary= "Delete project", description="Удалить проект из списка по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "204", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    projectService.delete(id);

    return ResponseEntity.noContent().build();
    }
   
}
