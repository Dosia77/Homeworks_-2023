package ru.gb.rest;

// import org.apache.el.stream.Optional;
// import org.hibernate.mapping.List;
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
import java.util.List;
import java.util.Optional;
import ru.gb.model.Employee;
import ru.gb.model.Timesheet;
import ru.gb.service.EmployeeService;


@RestController
@RequestMapping("/employees")
@Tag(name="Employees", description="API для работы с сотрудниками")
public class EmployeeController {

    private  final EmployeeService employeeService;
   
    public EmployeeController(EmployeeService employeeService){

       this.employeeService = employeeService;
    }

     @Operation(summary= "Get employee", description="Получить сотрудника по индентификатору",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id){
        Optional<Employee> ts = employeeService.findById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }

    @Operation(summary= "Get employee's timesheets", description="Получить записи рабочего времени сотрудника по индентификатору сотрудника",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping("/{id}/timesheets")
    public  ResponseEntity<List<Timesheet>> getAllTimesheets(@PathVariable Long id){

      return ResponseEntity.ok(employeeService.getEmployeeTimesheets(id));
    }
     
    
    @Operation(summary= "Get all employees", description="Получить список всех сотрудников",
    responses = {
        @ApiResponse(description = "Успешный ответ", responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class))),
        @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
        @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @GetMapping
    public ResponseEntity<List<Employee>>getAll(){
       return ResponseEntity.ok(employeeService.getAll());
    }

    @Operation(summary= "Post employee", description="Добавить нового сотрудника в список.",
    responses = {
            @ApiResponse(description = "Успешный ответ", responseCode = "201", content = @Content(schema = @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @PostMapping
    public ResponseEntity<Employee>  create(@RequestBody Employee employee){
    employee =  employeeService.create(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body(employee);
}
    
    @Operation(summary= "Delete employee's", description="Удалить сотрудника из списка по его идентификатору",
    responses = {
            @ApiResponse(description = "Успешный ответ", responseCode = "204", content = @Content(schema = @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Проект не найден", responseCode = "404", content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(description = "Внутренняя ошибка", responseCode = "500", content = @Content(schema = @Schema(implementation = void.class)))
    })
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    employeeService.delete(id);

    return ResponseEntity.noContent().build();
    }

}
