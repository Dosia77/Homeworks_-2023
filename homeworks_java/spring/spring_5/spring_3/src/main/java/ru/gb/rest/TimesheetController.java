package ru.gb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Timesheet;
import ru.gb.service.TimesheetService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

private  final TimesheetService service;

     @Autowired
    public TimesheetController(TimesheetService service){
        this.service = service;
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> get(@PathVariable Long id){
        Optional<Timesheet> ts = service.findById(id);

       if(ts.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
       }

       return  ResponseEntity.notFound().build();
    }
    
   
    @GetMapping
    public ResponseEntity<List<Timesheet>>getAll(){
       return ResponseEntity.ok(service.getAll());
    }


  @PostMapping
  public ResponseEntity<Timesheet>  create(@RequestBody Timesheet timesheet){

         timesheet = service.create(timesheet);

        if(timesheet != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
        }

        return  ResponseEntity.notFound().build();

   
}

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);

    return ResponseEntity.noContent().build();
    }

}
