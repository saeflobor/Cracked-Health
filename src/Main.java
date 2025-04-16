import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Create the health condition checker
        HealthConditionChecker healthChecker = new HealthConditionChecker();

        while (running) {
            // Display the menu
            showWelcomeMessage();

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    healthChecker.checkHealthCondition(scanner); // Check and record health condition
                    break;
                case 2:
                    healthChecker.dailyHealthTracker.showDailyTrack();  // Show daily track
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
        System.out.println("0. Exit");
    }
}
