package liquidtracking;

import java.io.*;
import java.util.*;
import java.text.*;

public class LiquidTrackerService {

    private int totalWaterConsumed; // In milliliters
    private int dailyWaterGoal; // In milliliters
    private String currentDate; // Current date as a string

    public LiquidTrackerService() {
        this.totalWaterConsumed = 0;
        this.dailyWaterGoal = 2000; // Default goal: 2 liters
        this.currentDate = getCurrentDate();
        loadWaterConsumption();
    }

    // Get the current date in "yyyy-MM-dd" format
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    // Load the previous day's water consumption from the CSV file
    private void loadWaterConsumption() {
        try (BufferedReader br = new BufferedReader(new FileReader("liquid_consumption.csv"))) {
            String line;
            boolean dataFound = false;

            while ((line = br.readLine()) != null) {
                String[] record = line.split(", ");
                if (record.length == 2) {
                    String date = record[0];
                    int consumedWater = Integer.parseInt(record[1]);

                    // Check if the record's date matches the current date
                    if (date.equals(currentDate)) {
                        this.totalWaterConsumed = consumedWater;
                        dataFound = true;
                    }
                }
            }

            // If no record found for today, reset water consumption
            if (!dataFound) {
                this.totalWaterConsumed = 0;
            }

        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
    }

    // Save the updated water consumption data to CSV
    private void saveWaterConsumptionToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("liquid_consumption.csv", true))) {
            writer.append(currentDate + ", " + totalWaterConsumed + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    // Set the daily water goal
    public void setDailyWaterGoal(Scanner scanner) {
        System.out.print("Enter your daily water intake goal in ml (default is 2000 ml): ");
        this.dailyWaterGoal = scanner.nextInt();
        System.out.println("\nDaily water intake goal updated to " + dailyWaterGoal + " ml.");

        // Save the updated daily water goal to the CSV file (optional)
        saveWaterGoalToCSV();
    }

    // Save the daily water goal to CSV
    private void saveWaterGoalToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("liquid_consumption.csv", true))) {
            writer.append("Daily Water Goal, " + dailyWaterGoal + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    // Track water consumption
    public void trackWaterConsumption(Scanner scanner) {
        System.out.print("Enter the amount of water consumed (in ml): ");
        int waterConsumed = scanner.nextInt();
        totalWaterConsumed += waterConsumed;
        System.out.println("Total water consumed today: " + totalWaterConsumed + " ml");

        // Save the water consumption to the CSV file
        saveWaterConsumptionToCSV();
    }

    // Display water consumption status
    public void displayWaterConsumptionStatus() {
        System.out.println("\nWater Consumption Status for " + currentDate + ":");
        System.out.println("+----------------------------+---------------------+");
        System.out.println("| Water Consumed (in ml)     | Remaining Goal (ml) |");
        System.out.println("+----------------------------+---------------------+");

        System.out.println(String.format("| %-26d| %-19d |", totalWaterConsumed, dailyWaterGoal - totalWaterConsumed));
        System.out.println("+----------------------------+---------------------+");
    }
}
