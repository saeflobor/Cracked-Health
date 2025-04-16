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
            // Display the menu
            showWelcomeMessage();

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
                case 3:
                    medicineTracker.setMedicationDetails(scanner);  // Set medication details
                    break;
                case 4:
                    medicineTracker.updateDoses(scanner);  // Update medication doses
                    break;
                case 5:
                    medicineTracker.displayMedicationTracker();  // Display medication tracker
                    break;
                case 6:
                    liquidTracker.setDailyWaterGoal(scanner);  // Set water goal
                    break;
                case 7:
                    liquidTracker.trackWaterConsumption(scanner);  // Track water consumption
                    break;
                case 8:
                    liquidTracker.displayWaterConsumptionStatus();  // Display water status
                    break;
                case 0:
                    running = false;  // Exit the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();  // Close the scanner object to avoid resource leaks
    }

    private static void showWelcomeMessage() {
        System.out.println("Welcome to Cracked-Health!");
        System.out.println("1. Health Condition Checker");
        System.out.println("2. View Daily Health Track");
        System.out.println("3. Set Medication Details");
        System.out.println("4. Update Medication Doses");
        System.out.println("5. View Medication Tracker");
        System.out.println("6. Set Daily Water Goal");
        System.out.println("7. Track Water Consumption");
        System.out.println("8. View Water Consumption Status");
        System.out.println("0. Exit");
    }
}
