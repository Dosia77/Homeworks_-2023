package ru.gb.service;

import ru.gb.page.TimesheetPageDto;
import ru.gb.page.TimesheetPageRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TimesheetPageService {

    private final TimesheetPageRepository repository;
   
    public TimesheetPageService(TimesheetPageRepository repository) {
       
       this.repository = repository;
    }

  public List<TimesheetPageDto> getAll(){
          return repository.getAll();
      
    }

    public Optional<TimesheetPageDto> findById(String id){  
           return repository.getById(id);
        }
   
    
    }


