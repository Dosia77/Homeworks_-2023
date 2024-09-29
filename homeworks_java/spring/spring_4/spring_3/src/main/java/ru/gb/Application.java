package ru.gb;

import org.springframework.context.ApplicationContext;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.model.Project;
import ru.gb.model.Timesheet;
//import ru.gb.model.TimesheetPageDto;
import ru.gb.page.TimesheetPageRepository;
import ru.gb.repository.ProjectRepository;
import ru.gb.repository.TimesheetRepository;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = (ApplicationContext) SpringApplication.run(Application.class, args);

		ProjectRepository repository = context.getBean(ProjectRepository.class);

		for (int i=1; i<=10; i++){
			Project project = new Project();
			project.setId((long)i);			
			project.setName("Project #"+i);
			repository.create(project);

		}
	
		TimesheetRepository timesheetRepository = context.getBean(TimesheetRepository.class);
        TimesheetPageRepository timesheetPageRepository = context.getBean(TimesheetPageRepository.class);

		LocalDate createdAt = LocalDate.now();
		for(int i= 1; i<=10; i++){
			createdAt = createdAt.plusDays(1);

			Timesheet timesheet = new Timesheet();
			timesheet.setId((long)i);
			timesheet.setProjectId(ThreadLocalRandom.current().nextLong(1,11));
			timesheet.setCreatedAt(createdAt);
			timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));			
			timesheetPageRepository.convert(timesheetRepository.create(timesheet));
		
		}
	
	}

}
