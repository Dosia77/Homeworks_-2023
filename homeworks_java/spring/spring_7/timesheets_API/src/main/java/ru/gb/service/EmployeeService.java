package ru.gb.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import ru.gb.model.Employee;
import ru.gb.model.Timesheet;
import ru.gb.page.TimesheetPageRepository;
import ru.gb.repository.EmployeeRepository;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TimesheetService tService;
   private final TimesheetPageRepository timesheetPageRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TimesheetService tService, TimesheetPageRepository timesheetPageRepository){//}, TimesheetRepository tRepository){
        this.employeeRepository = employeeRepository;
        this.tService = tService;
       this.timesheetPageRepository = timesheetPageRepository;
    }

    
    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll(){
        return  employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public void addTimesheet(Long id){

        Optional<Employee> emp = findById(id);

        if(emp.isPresent()){
            Employee employee = emp.get();
            HashSet<Long> projectsId = employee.getProjectsId();
            for (var projectId : projectsId){

		        LocalDate createdAt = LocalDate.now();

	 		createdAt = createdAt.plusDays(1);

	 		Timesheet timesheet = new Timesheet();
	 		timesheet.setEmployeeId(employee.getId());
	 		timesheet.setProjectId(projectId);
	 		timesheet.setCreatedAt(createdAt);
	 		timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

            timesheetPageRepository.convert(tService.create(timesheet));

            }
        }
    }


    public List<Timesheet> getEmployeeTimesheets(Long id){

        List<Timesheet> timesheets = new ArrayList<>();
        Optional<Employee> es = findById(id);
        if(es.isPresent()){
            List<Timesheet> allTimesheets = tService.getAll();
            for(var timesheet: allTimesheets){
                if(Objects.equals(timesheet.getEmployeeId(), es.get().getId())){
                    timesheets.add(timesheet);
                }
            }

            return timesheets;
        }

      return null;
    }

}
