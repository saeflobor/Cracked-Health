package menu;

import medication.MedicineTrackerService;
import utils.TerminalUtils;

import java.util.Scanner;

public class MedicineMenu {

    private Scanner scanner;
    private MedicineTrackerService medicineTracker;

    public MedicineMenu(Scanner scanner, MedicineTrackerService medicineTracker) {
        this.scanner = scanner;
        this.medicineTracker = medicineTracker;
    }

    public void displayMedicineMenu() {
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            System.out.println("\nMedicine Tracker Menu:");
            System.out.println("1. Set Medication Details");
            System.out.println("2. Update Medication Doses");
            System.out.println("3. View Medication Tracker");
            System.out.println("4. Track Daily Medicine Consumption");
            System.out.println("5. View Daily Medicine Consumption Summary");
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
                    medicineTracker.trackDailyMedicineConsumption(scanner);  // Track daily medicine consumption
                    break;
                case 5:
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
