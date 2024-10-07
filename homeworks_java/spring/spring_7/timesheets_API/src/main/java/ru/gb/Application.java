package ru.gb;

import org.springframework.context.ApplicationContext;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.model.Employee;
import ru.gb.model.Project;
import ru.gb.model.Role;
import ru.gb.model.User;
import ru.gb.repository.RoleRepository;
import ru.gb.repository.UserRepository;
import ru.gb.service.EmployeeService;
import ru.gb.service.ProjectService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = (ApplicationContext) SpringApplication.run(Application.class, args);

		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		Role role1 = new Role("admin");
		roleRepository.save(role1);
		Role role2 = new Role("user");
		roleRepository.save(role2);
		Role role3 = new Role("rest");
		roleRepository.save(role3);

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();

		user1.setLogin("admin");
		user1.setPassword("$2a$12$AR7.LY.s5rNPnA8arF8.9ebbsGfGDj3U6giJmx8gotFQWkP2.ybbK");
        user1.addRole(role1);
		user1.addRole(role2);
		user1.addRole(role3);
		userRepository.save(user1);

		user2.setLogin("user");
		user2.setPassword("$2a$12$uvHlkAEQKt90B6dLG4FsS.wmstBJAcxATJkGYrH.ZjosgyFHhfNIy");
		user2.addRole(role2);
		user2.addRole(role3);
		userRepository.save(user2);

		user3.setLogin("rest");
		user3.setPassword("$2a$12$c6dixPcsSCOw0sksq3khteuvev8CBn/0su9wYTRwPtVRPPXnPGn/y");
		user3.addRole(role3);
		userRepository.save(user3);

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


