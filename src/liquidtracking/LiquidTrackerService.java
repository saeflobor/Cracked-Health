package liquidtracking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LiquidTrackerService {

    private int totalWaterConsumed; // In milliliters
    private int dailyWaterGoal; // In milliliters

    public LiquidTrackerService() {
        this.totalWaterConsumed = 0;
        this.dailyWaterGoal = 2000; // Default goal: 2 liters
    }

    // Set the daily water goal
    public void setDailyWaterGoal(Scanner scanner) {
        System.out.print("Enter your daily water intake goal in ml (default is 2000 ml): ");
        this.dailyWaterGoal = scanner.nextInt();
        System.out.println("\nDaily water intake goal updated to " + dailyWaterGoal + " ml.");

        // Save the updated daily water goal to the CSV file
        saveWaterGoalToCSV();
    }

    // Track water consumption
    public void trackWaterConsumption(Scanner scanner) {
        System.out.print("Enter the amount of water consumed (in ml): ");
        int waterConsumed = scanner.nextInt();
        totalWaterConsumed += waterConsumed;
        System.out.println("Total water consumed today: " + totalWaterConsumed + " ml");

        // Save the water consumption to the CSV file
        saveWaterConsumptionToCSV(waterConsumed);
    }

    // Display water consumption status
    public void displayWaterConsumptionStatus() {
        int totalWaterConsumed = 0;
        int dailyWaterGoal = 2000; // Default goal if no data found in the CSV file

        // Step 1: Read the water consumption and daily goal from CSV
        try (BufferedReader br = new BufferedReader(new FileReader("liquid_consumption.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(", ");
                if (record.length == 2) {
                    if (record[0].equals("Water Consumed")) {
                        totalWaterConsumed = Integer.parseInt(record[1]);  // Update total water consumed
                    } else if (record[0].equals("Daily Water Goal")) {
                        dailyWaterGoal = Integer.parseInt(record[1]);  // Update daily water goal
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }

        // Step 2: Display the water consumption status
        System.out.println("\nWater Consumption Status:");
        System.out.println("+----------------------------+---------------------+");
        System.out.println("| Water Consumed (in ml)     | Remaining Goal (ml) |");
        System.out.println("+----------------------------+---------------------+");

        System.out.println(String.format("| %-26d| %-19d |", totalWaterConsumed, dailyWaterGoal - totalWaterConsumed));
        System.out.println("+----------------------------+---------------------+");
    }

    // Save daily water goal to CSV file
    private void saveWaterGoalToCSV() {
        try (FileWriter writer = new FileWriter("liquid_consumption.csv", true)) {
            writer.append("Daily Water Goal, " + dailyWaterGoal + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    // Save water consumption data to CSV file
    private void saveWaterConsumptionToCSV(int waterConsumed) {
        try (FileWriter writer = new FileWriter("liquid_consumption.csv", true)) {
            writer.append("Water Consumed, " + waterConsumed + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
