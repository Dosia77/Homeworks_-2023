package ru.gb.tickets;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketNumberGenerator {

    private String number;

    public TicketNumberGenerator() {
        this.number = createNewNumber();
    }

    public String createNewNumber(){
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
      return number;
    }

}
