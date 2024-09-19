package ru.gb.tickets;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Scoreboard {


private Ticket ticket;

public Scoreboard(){
    this.ticket = new Ticket();
}

    @Override
    public String toString() {
        return "Scoreboard{" +
                ticket +
                '}';
    }
}
