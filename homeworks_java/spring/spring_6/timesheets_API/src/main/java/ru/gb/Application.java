package ru.gb;

import org.springframework.context.ApplicationContext;
import java.util.HashSet;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.model.Employee;
import ru.gb.model.Project;
import ru.gb.service.EmployeeService;
import ru.gb.service.ProjectService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = (ApplicationContext) SpringApplication.run(Application.class, args);

	   	ProjectService projectService = context.getBean(ProjectService.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
	 	String [] names = {"one", "two", "three","four", "five","six","seven","eight","nine","ten"};

	 	Random random = new Random();

	 	for (int i=1; i<=10; i++){
	 		Project project = new Project();
	 		project.setId((long)i);
	 		project.setName("Project #"+i);
	 		projectService.create(project);

	 	}

		for(int i = 1; i<=10; i++){

			HashSet<Long> projectsId = new HashSet<>();
			int size = random.nextInt(1,6);
			for(int j =0; j<size; j++){

				projectsId.add(random.nextLong(1,11));

			}

			Employee employee = new Employee();

			employee.setName(names[random.nextInt(names.length)]);
			employee.setLastName(names[random.nextInt(names.length)]);
			employee.setProjectsId(projectsId);
			employeeService.create(employee);
		}

		for(int i = 1; i<=10; i++){
			employeeService.addTimesheet((long)i);
		}

	 	}
	}


