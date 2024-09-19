package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.gb.tickets.Scoreboard;
import ru.gb.tickets.Ticket;
import ru.gb.tickets.TicketNumberGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);

		for(int i=0; i<5; i++){
			Scoreboard sb = context.getBean(Scoreboard.class);
			System.out.println(sb);
		}
	}

}
