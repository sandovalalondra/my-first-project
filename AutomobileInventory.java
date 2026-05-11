package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class AutomobileInventory {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);

            Automobile vehicle = new Automobile("Toyota", "Camry", "White", 2020, 45000);

            System.out.println("Original Vehicle Information:");
            String[] vehicleInfo = vehicle.listVehicleInformation();

            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println();

            String removeMessage = vehicle.removeVehicle();
            System.out.println(removeMessage);

            System.out.println();

            String addMessage = vehicle.addVehicle("Honda", "Civic", "Black", 2022, 15000);
            System.out.println(addMessage);

            System.out.println();

            System.out.println("New Vehicle Information:");
            vehicleInfo = vehicle.listVehicleInformation();

            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println();

            String updateMessage = vehicle.updateVehicle("Ford", "Mustang", "Red", 2023, 5000);
            System.out.println(updateMessage);

            System.out.println();

            System.out.println("Updated Vehicle Information:");
            vehicleInfo = vehicle.listVehicleInformation();

            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println();

            System.out.print("Would you like to print the vehicle information to a file? Enter Y or N: ");
            String response = input.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                printToFile(vehicleInfo);
                System.out.println("Vehicle information was printed to C:\\Temp\\Autos.txt");
            } else if (response.equalsIgnoreCase("N")) {
                System.out.println("A file will not be printed.");
            } else {
                System.out.println("Invalid response. A file will not be printed.");
            }

            input.close();

        } catch (Exception e) {
            System.out.println("Program failed: " + e.getMessage());
        }
    }

    public static void printToFile(String[] vehicleInfo) {
        try {
            File folder = new File("C:\\Temp");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            PrintWriter writer = new PrintWriter("C:\\Temp\\Autos.txt");

            writer.println("Vehicle Information");
            writer.println("-------------------");

            for (String info : vehicleInfo) {
                writer.println(info);
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Failed to print file: " + e.getMessage());
        }
    }
}