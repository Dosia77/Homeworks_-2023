package ru.gb.tickets;

import java.time.LocalDateTime;

public class Ticket {

    private TicketNumberGenerator number;
    private LocalDateTime createdAt;

    public Ticket() {
        this.number = new TicketNumberGenerator();
        this.createdAt = LocalDateTime.now();

    }

    public TicketNumberGenerator getNumber() {
        return number;
    }


    public LocalDateTime getTime() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Ticket #" +
                number +
                ", createdAt=" + createdAt +
                '}';
    }
}
