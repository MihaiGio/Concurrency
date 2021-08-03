package ro.siit;

import java.util.Random;

public enum TicketType {
    FULL, FULLVIP, FREEPASS, ONEDAY, ONEDAYVIP;

    private static final TicketType[] tickets = TicketType.values();
    private static final Random random = new Random();

    static TicketType random() {
        return tickets[random.nextInt(tickets.length)];
    }
}
