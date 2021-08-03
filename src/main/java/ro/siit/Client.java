package ro.siit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) {
        var gate = new FestivalGate();
        new FestivalStatisticsThread(gate).start();
        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> FestivalAttendeeThread.newAttendees(gate);
        ScheduledFuture<?> sf = s.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }

}
