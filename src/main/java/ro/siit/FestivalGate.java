package ro.siit;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class FestivalGate {

    private static final Queue<TicketType> tickets = new PriorityBlockingQueue<>();

    public Queue<TicketType> getTickets() {
        return tickets;
    }

    public void addTicket(TicketType ticket) {
        tickets.add(ticket);
    }

}
