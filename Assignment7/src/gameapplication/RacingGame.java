package gameapplication;

import java.util.Scanner;

public class RacingGame {

    private Biker[] bikers;

    public RacingGame(int noOfBikers) {
        bikers = new Biker[noOfBikers];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < noOfBikers; i++) {
            System.out.print("Enter the name of Biker " + (i + 1) + ": ");
            String name = scanner.next();
            bikers[i] = new Biker(name);
        }
    }

    private void displayResults() {
        System.out.println("Race Results: (Time in milliseconds)");
        System.out.println("Rank\tBiker Name\tStart Time\tEnd Time\tTotal Time");
        for (int i = 0; i < bikers.length; i++) {
            Biker biker = bikers[i];
            System.out.printf("%d\t%s\t\t%d\t%d\t%d%n",
                    i + 1, biker.getName(), biker.getStartTime(), biker.getEndTime(), biker.getTimeTaken());
        }
    }

    public void startRace() throws Exception {
        System.out.println("Race starting in:");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("Go!");

        Thread[] threads = new Thread[bikers.length];
        for (int i = 0; i < bikers.length; i++) {
            threads[i] = new Thread(bikers[i]);
            threads[i].start();
        }
        synchronized (Biker.lock) {
            Biker.gameStarted = true;
            Biker.lock.notifyAll();
        }

        boolean anyThreadAlive;
        do {
            anyThreadAlive = false;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    anyThreadAlive = true;
                    break;
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------");
            for (int i = 0; i < bikers.length; i++) {
                System.out.print(bikers[i].getName() + ": ");
                for (int j = 0; j < bikers[i].progress; j++) {
                    System.out.print("_");
                }
                System.out.println("o-`o");
            }
            System.out.println("----------------------------------------------------------------------------------------------");
            Thread.sleep(1000);
        } while (anyThreadAlive);

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < bikers.length - 1; i++) {
            for (int j = 0; j < bikers.length - i - 1; j++) {
                if (bikers[j].getEndTime() > bikers[j + 1].getEndTime()) {
                    Biker temp = bikers[j];
                    bikers[j] = bikers[j + 1];
                    bikers[j + 1] = temp;
                }
            }
        }
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