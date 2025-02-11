package gameapplication;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class RacingGame {

    private List<Biker> bikers;
    private CountDownLatch startLatch;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    
    public RacingGame(int noOfBikers) {
        bikers = new ArrayList<Biker>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < noOfBikers; i++) {
            System.out.print("Enter the name of Biker " + (i + 1) + ": ");
            String name = scanner.next();
            bikers.add(new Biker(name));
        }
        startLatch = new CountDownLatch(noOfBikers);
        Biker.startLatch = startLatch;
    }

    private void displayResults() {
        System.out.println("Race Results: (Total Time in milliseconds)");
        System.out.println("Rank\tBiker Name\tStart Time\tEnd Time\tTotal Time");
        for (int i = 0; i < bikers.size(); i++) {
            Biker biker = bikers.get(i);
            System.out.printf("%d\t%s\t\t%s\t%s\t%d%n",
                    i + 1, biker.getName(), biker.getStartTime().format(formatter), biker.getEndTime().format(formatter), biker.getTimeTaken());
        }
    }

    public void startRace() throws Exception {
        System.out.println("Race starting in:");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("Go!");

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < bikers.size(); i++) {
            threads.add(new Thread(bikers.get(i)));
            threads.get(i).start();
            Biker.startLatch.countDown();
        }
        startLatch.await(); 

        boolean anyThreadAlive;
        int time = 0;
        do {
            anyThreadAlive = false;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    anyThreadAlive = true;
                    break;
                }
            }
            System.out.println("--------------------------------------------" + time + " sec--------------------------------------------------");
            for (int i = 0; i < bikers.size(); i++) {
                System.out.print(bikers.get(i).getName() + ": ");
                for (int j = 0; j < bikers.get(i).getProgress(); j++) {
                    System.out.print("_");
                }
                System.out.println("o-`o");
            }
            System.out.println("---------------------------------------------------------------------------------------------------");
            time++;
            Thread.sleep(1000);
        } while (anyThreadAlive);

        for (Thread thread : threads) {
            thread.join();
        }

        Collections.sort(bikers, Comparator.comparing(Biker::getEndTime));

        displayResults();
    }

    public static void main(String[] args) {
        try {
            RacingDetails details = new RacingDetails();
            RacingGame race = new RacingGame(RacingDetails.noOfBikers);
            race.startRace();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}