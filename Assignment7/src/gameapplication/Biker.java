package gameapplication;

public class Biker implements Runnable {
    private String name;
    private long startTime;
    private long endTime;
    private long timeTaken;
    public static boolean gameStarted;
    static Object lock = new Object();
    public int progress;

    public Biker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getTimeTaken() {
        return this.timeTaken;
    }

    public void run() {
        synchronized (lock) {
            while (!gameStarted) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        this.startTime = System.currentTimeMillis();

        for (int i = 1; i <= RacingDetails.distance; i++) {
            try {
                Thread.sleep((int) (Math.random() * 100));
                progress = i;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.endTime = System.currentTimeMillis();
        this.timeTaken = endTime - startTime;
    }
}