package menu;

import liquidtracking.LiquidTrackerService;
import medication.MedicineTrackerService;
import utils.TerminalUtils;

import java.util.Scanner;

public class MedAndLiquidMenu {

    private Scanner scanner;
    private MedicineTrackerService medicineTracker;
    private LiquidTrackerService liquidTracker;

    public MedAndLiquidMenu(Scanner scanner, MedicineTrackerService medicineTracker, LiquidTrackerService liquidTracker) {
        this.scanner = scanner;
        this.medicineTracker = medicineTracker;
        this.liquidTracker = liquidTracker;
    }

    public void displayMedAndLiquidMenu() {
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            System.out.println("\nMed and Liquid Tracker Menu:");
            System.out.println("1. Set Medication Details");
            System.out.println("2. Update Medication Doses");
            System.out.println("3. View Medication Tracker");
            System.out.println("4. Set Daily Water Goal");
            System.out.println("5. Track Water Consumption");
            System.out.println("6. View Water Consumption Status");
            System.out.println("7. Track Daily Medicine Consumption");
            System.out.println("8. View Daily Medicine Consumption Summary");
            System.out.println("0. Back to Main Menu");

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    medicineTracker.setMedicationDetails(scanner);  // Set medication details
                    break;
                case 2:
                    medicineTracker.updateDoses(scanner);  // Update medication doses
                    break;
                case 3:
                    medicineTracker.displayMedicationTracker();  // Display medication tracker
                    break;
                case 4:
                    liquidTracker.setDailyWaterGoal(scanner);  // Set water goal
                    break;
                case 5:
                    liquidTracker.trackWaterConsumption(scanner);  // Track water consumption
                    break;
                case 6:
                    liquidTracker.displayWaterConsumptionStatus();  // Display water status
                    break;
                case 7:
                    medicineTracker.trackDailyMedicineConsumption(scanner);  // Track daily medicine consumption
                    break;
                case 8:
                    medicineTracker.displayDailyConsumptionSummary();  // View daily medicine consumption summary
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
