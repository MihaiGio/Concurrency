package ro.siit;

import java.util.Random;

public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType;
    private FestivalGate festivalGate;
    private static final Random random = new Random();

    public FestivalAttendeeThread() {
    }

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public FestivalGate getFestivalGate() {
        return festivalGate;
    }

    @Override
    public void run() {
        try {
            var gate = getFestivalGate();
            var randomTicket = getTicketType();
            gate.addTicket(randomTicket);
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    /**
     * This method generates a random number of FestivalAttendeeThreads with a range between 100 and 200 threads.
     *
     * @param gate the location where the random ticket data is stored.
     */
    public static void newAttendees(FestivalGate gate) {
        var randomInt = random.nextInt(100) + 100;
        for (var i = 0; i < randomInt; i++) {
            var ticket = TicketType.random();
            new FestivalAttendeeThread(ticket, gate).start();
        }
    }
}
