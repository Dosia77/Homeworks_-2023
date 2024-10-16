package ru.gb.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.service.TimesheetPageService;


@Controller
@RequestMapping("/timesheets")

public class TimesheetPageController {

private final TimesheetPageService service;


    public TimesheetPageController(TimesheetPageService service){
        this.service = service;
       
    }

    @GetMapping
    public String getAllTimesheets(Model model){
       List<TimesheetPageDto> timesheets = service.findAll();
        model.addAttribute("timesheets", timesheets);
    
        return "timesheets-page.html";

    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {

        Optional<TimesheetPageDto> timesheetOpt = service.findById(id);
        if(timesheetOpt.isEmpty()){
            throw new NoSuchElementException();
        }

        model.addAttribute("timesheet", timesheetOpt.get());
         return "timesheet-page.html";

    }

}
