package ru.gb;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//@EnableDiscoveryClient
//@EnableEurekaServer
@SpringBootApplication
public class TimesheetPageApplication {

	public static void main(String[] args) {

		ApplicationContext context = (ApplicationContext) SpringApplication.run(TimesheetPageApplication.class, args);


	 	}
	}

