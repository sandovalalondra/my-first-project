package main;
import java.util.Scanner;

public class MonthlyTemperatures {

    public static void main(String[] args) {

        // Array holding the names of the months
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        // Array holding the average temperature for each month
        double[] temperatures = {
                30.5, 32.0, 45.1, 55.3, 65.8, 75.2,
                82.4, 80.9, 71.6, 58.7, 45.9, 33.8
        };

        Scanner input = new Scanner(System.in);

        // Prompt the user for a month or for the full year
        System.out.print("Enter a month to view its average temperature or type 'year': ");
        String userEntry = input.nextLine();

        // If the user wants to see the entire year
        if (userEntry.equalsIgnoreCase("year")) {

            double total = 0;
            double highest = temperatures[0];
            double lowest = temperatures[0];

            System.out.println("\nMonthly Temperatures:");
            System.out.println("----------------------");

            // Loop through both arrays
            for (int i = 0; i < months.length; i++) {
                System.out.println(months[i] + ": " + temperatures[i] + "°F");
                total += temperatures[i];

                // Check for highest temperature
                if (temperatures[i] > highest) {
                    highest = temperatures[i];
                }

                // Check for lowest temperature
                if (temperatures[i] < lowest) {
                    lowest = temperatures[i];
                }
            }

            double yearlyAverage = total / temperatures.length;

            System.out.println("\nYearly Average Temperature: " + yearlyAverage + "°F");
            System.out.println("Highest Monthly Average: " + highest + "°F");
            System.out.println("Lowest Monthly Average: " + lowest + "°F");
        } else {

            boolean found = false;

            // Search for the month entered by the user
            for (int i = 0; i < months.length; i++) {
                if (userEntry.equalsIgnoreCase(months[i])) {
                    System.out.println("\nMonth: " + months[i]);
                    System.out.println("Average Temperature: " + temperatures[i] + "°F");
                    found = true;
                    break;
                }
            }

            // If the month was not found
            if (!found) {
                System.out.println("Month not found. Please enter a valid month name.");
            }
        }

        input.close();
    }
}
