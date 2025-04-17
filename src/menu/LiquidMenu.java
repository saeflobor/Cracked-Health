package menu;

import liquidtracking.LiquidTrackerService;
import utils.TerminalUtils;

import java.util.Scanner;

public class LiquidMenu {

    private Scanner scanner;
    private LiquidTrackerService liquidTracker;

    public LiquidMenu(Scanner scanner, LiquidTrackerService liquidTracker) {
        this.scanner = scanner;
        this.liquidTracker = liquidTracker;
    }

    public void displayLiquidMenu() {
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            TerminalUtils.showApplicationName();
            System.out.println("\nLiquid Tracker Menu:");
            System.out.println("1. Set Daily Water Goal");
            System.out.println("2. Track Water Consumption");
            System.out.println("3. View Water Consumption Status");
            System.out.println("0. Back to Main Menu");

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    liquidTracker.setDailyWaterGoal(scanner);  // Set water goal
                    break;
                case 2:
                    liquidTracker.trackWaterConsumption(scanner);  // Track water consumption
                    break;
                case 3:
                    liquidTracker.displayWaterConsumptionStatus();  // Display water status
                    break;
                case 0:
                    submenuRunning = false;  // Go back to the main menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
