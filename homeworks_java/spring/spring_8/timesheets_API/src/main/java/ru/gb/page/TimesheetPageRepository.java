package ru.gb.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import lombok.Data;
import ru.gb.model.Project;
import ru.gb.model.Timesheet;
import ru.gb.repository.ProjectRepository;

@Repository
@Data
public class TimesheetPageRepository {

     private final List<TimesheetPageDto> timesheetsPageDtos = new ArrayList<>();
     private final ProjectRepository projectRepository;

    public TimesheetPageRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<TimesheetPageDto> getById(String id) {
        return timesheetsPageDtos.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

      public TimesheetPageDto convert(Timesheet timesheet){

        Project project = projectRepository.findById(timesheet.getProjectId()).get();
        
        TimesheetPageDto timesheetPageDto = new TimesheetPageDto();

        timesheetPageDto.setProjectName(project.getName());
        timesheetPageDto.setProjectId(String.valueOf(project.getId()));
        timesheetPageDto.setId(String.valueOf(timesheet.getId()));
        timesheetPageDto.setMinutes(String.valueOf(timesheet.getMinutes()));
        timesheetPageDto.setCreatedAt(timesheet.getCreatedAt().toString());

        timesheetsPageDtos.add(timesheetPageDto);
        return timesheetPageDto;
        }

        public List<TimesheetPageDto> getAll(){
            return List.copyOf(timesheetsPageDtos);
        }

        public void delete(Long id){
            timesheetsPageDtos.stream()
                    .filter(it -> Objects.equals(it.getId(), id))
                    .findFirst()
                    .ifPresent(timesheetsPageDtos::remove);
        }
    
}
