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

//import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.Optional;

import ru.gb.model.Employee;

import ru.gb.model.Timesheet;
import ru.gb.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private  final EmployeeService employeeService;
   
    public EmployeeController(EmployeeService employeeService){

       this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id){
        Optional<Employee> ts = employeeService.findById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }


     @GetMapping("/{id}/timesheets")
    public  ResponseEntity<List<Timesheet>> getAllTimesheets(@PathVariable Long id){

      return ResponseEntity.ok(employeeService.getEmployeeTimesheets(id));
    }
       
    @GetMapping
    public ResponseEntity<List<Employee>>getAll(){
       return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<Employee>  create(@RequestBody Employee employee){
   employee =  employeeService.create(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body(employee);
}

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    employeeService.delete(id);

    return ResponseEntity.noContent().build();
    }

}
