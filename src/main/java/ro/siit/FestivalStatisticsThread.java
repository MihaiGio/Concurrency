package ro.siit;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class FestivalStatisticsThread extends Thread {

    private final FestivalGate festivalGate;

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    public FestivalGate getFestivalGate() {
        return festivalGate;
    }

    @Override
    public void run() {
        try {
            var gate = getFestivalGate();
            Queue<TicketType> a = gate.getTickets();
            PriorityBlockingQueue<TicketType> b = new PriorityBlockingQueue<>();
            b.addAll(a);
            List<TicketType> listTicket = new ArrayList<>();
            var numberOfElements = b.drainTo(listTicket);
            int occurrencesFULL = Collections.frequency(listTicket, TicketType.FULL);
            int occurrencesFULLVIP = Collections.frequency(listTicket, TicketType.FULLVIP);
            int occurrencesFREEPASS = Collections.frequency(listTicket, TicketType.FREEPASS);
            int occurrencesONEDAY = Collections.frequency(listTicket, TicketType.ONEDAY);
            int occurrencesONEDAYVIP = Collections.frequency(listTicket, TicketType.ONEDAYVIP);
            if (gate.getTickets().isEmpty()) {
                System.out.println("No people at the festival yet :(.");
            } else {
                System.out.println("\n" + numberOfElements + " people entered;" + "\n" +
                        occurrencesFULL + " people have full tickets;" + "\n" +
                        occurrencesFREEPASS + " people have free passes;" + "\n" +
                        occurrencesFULLVIP + " people have full VIP passes;" + "\n" +
                        occurrencesONEDAY + " people have one-day passes;" + "\n" +
                        occurrencesONEDAYVIP + " people have one-day VIP passes;");
            }
            Thread.sleep(5000);
            run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
