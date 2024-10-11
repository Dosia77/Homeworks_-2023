package ru.gb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.gb.model.Employee;
import ru.gb.model.Timesheet;
import ru.gb.service.TimesheetService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
@Tag(name="Timesheets", description="API для работы с записями рабочего времени")
public class TimesheetController {

private  final TimesheetService service;

     @Autowired
    public TimesheetController(TimesheetService service){
        this.service = service;
       
    }

    @Operation(summary= "Get timesheet", description="Получить запись по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> get(@PathVariable Long id){
        Optional<Timesheet> ts = service.findById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }
    
   
    @Operation(summary= "Get all timesheets", description="Получить все записи",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping
    public ResponseEntity<List<Timesheet>>findAll(){
       return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary= "Post timesheet", description="Добавить новую запись",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "201", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @PostMapping
    public ResponseEntity<Timesheet>  create(@RequestBody Timesheet timesheet){

            timesheet = service.create(timesheet);

            if(timesheet != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
            }

            return  ResponseEntity.notFound().build();

    
    }

    @Operation(summary= "Delete timesheet", description="Удалить запись по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "204", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
    }

}
