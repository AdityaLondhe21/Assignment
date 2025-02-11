package gameapplication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Biker implements Runnable {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long timeTaken;
    public static CountDownLatch startLatch;
    private int progress;

    public Biker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public long getTimeTaken() {
        return this.timeTaken;
    }

    public int getProgress() {
        return progress;
    }

    public void run() {
        try {
            startLatch.await();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.startTime = LocalDateTime.now();

        for (progress = 1; progress <= RacingDetails.distance; progress++) {
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.endTime = LocalDateTime.now();
        this.timeTaken = Duration.between(startTime, endTime).toMillis();
    }
}