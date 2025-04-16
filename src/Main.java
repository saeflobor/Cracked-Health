import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Create services
        HealthConditionChecker healthChecker = new HealthConditionChecker();
        MedicineTrackerService medicineTracker = new MedicineTrackerService();
        LiquidTrackerService liquidTracker = new LiquidTrackerService();

        while (running) {
            // Display the main menu
            showMainMenu();

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Health Condition Checker Submenu
                    healthConditionCheckerMenu(scanner, healthChecker);
                    break;
                case 2:
                    // Med and Liquid Tracker Submenu
                    medAndLiquidTrackerMenu(scanner, medicineTracker, liquidTracker);
                    break;
                case 0:
                    running = false;  // Exit the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
//            TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
        }

        scanner.close();  // Close the scanner object to avoid resource leaks
    }

    // Main menu
    private static void showMainMenu() {
        System.out.println("\nWelcome to Cracked-Health!");
        System.out.println("1. Health Condition Checker");
        System.out.println("2. Med and Liquid Tracker");
        System.out.println("0. Exit");
    }

    // Health Condition Checker Submenu
    private static void healthConditionCheckerMenu(Scanner scanner, HealthConditionChecker healthChecker) {
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            System.out.println("\nHealth Condition Checker Menu:");
            System.out.println("1. Check Health Condition");
            System.out.println("2. View Daily Health Track");
            System.out.println("0. Back to Main Menu");

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    healthChecker.checkHealthCondition(scanner);  // Check and record health condition
                    break;
                case 2:
                    healthChecker.dailyHealthTracker.showDailyTrack();  // Show daily track
                    break;
                case 0:
                    submenuRunning = false;  // Go back to the main menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Med and Liquid Tracker Submenu
    private static void medAndLiquidTrackerMenu(Scanner scanner, MedicineTrackerService medicineTracker, LiquidTrackerService liquidTracker) {
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
                case 0:
                    submenuRunning = false;  // Go back to the main menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
