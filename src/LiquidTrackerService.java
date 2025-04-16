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
    }

    // Track water consumption
    public void trackWaterConsumption(Scanner scanner) {
        System.out.print("Enter the amount of water consumed (in ml): ");
        int waterConsumed = scanner.nextInt();
        totalWaterConsumed += waterConsumed;
        System.out.println("Total water consumed today: " + totalWaterConsumed + " ml");
    }

    // Display water consumption status
    public void displayWaterConsumptionStatus() {
        System.out.println("\n" + "\033[32m" + "Water Consumption Status:" + "\033[0m");
        System.out.println("+----------------------------+---------------------+");
        System.out.println("| Water Consumed (in ml)     | Remaining Goal (ml) |");
        System.out.println("+----------------------------+---------------------+");
        System.out.println(String.format("| %-26d| %-19d |", totalWaterConsumed, dailyWaterGoal - totalWaterConsumed));
        System.out.println("+----------------------------+---------------------+");
    }
}
