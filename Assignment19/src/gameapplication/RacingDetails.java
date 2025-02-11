package gameapplication;

import java.util.Scanner;

class RacingDetails {
    static int noOfBikers;
    static int distance;
    static String unit = "Meters";

    RacingDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of bikers: ");
        noOfBikers = scanner.nextInt();
        System.out.print("Enter the race distance in meters: ");
        distance = scanner.nextInt();
    }
}