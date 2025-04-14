import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object for user input
        boolean running = true;  // Variable to control the main loop

        // Show the application name in the center with red for "Cracked", green for "Health",
        // green for borders, and a red message in the corner below the name
        showApplicationName();

        // Create an instance of HealthConditionChecker
        HealthConditionChecker healthChecker = new HealthConditionChecker();

        // Create an instance of SuggestionService
        SuggestionService suggestionService = new SuggestionService();

        // Create an instance of DoctorRecommendationService
        DoctorRecommendationService doctorRecommendationService = new DoctorRecommendationService();

        // Create an instance of RoutineService
        RoutineService routineService = new RoutineService();

        // Create an instance of MedLiquidTrackerService
        MedLiquidTrackerService medLiquidTrackerService = new MedLiquidTrackerService();

        while (running) {
            // Display the welcome message and menu options with colors
            showWelcomeMessage();

            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after reading an integer

            // Based on the user's choice, call the appropriate method
            switch (choice) {
                case 1:
                    String healthStatus = healthChecker.checkHealthCondition(scanner);  // Check the user's health condition
                    System.out.println("\n\033[31mHealth Status: " + healthStatus + "\033[0m");  // Display health status in red
                    pauseBeforeReturning();  // Wait for user input before returning to the main menu
                    break;
                case 2:
                    // Ask the user to choose their health status from options
                    System.out.println("\nSelect your health status from the following options:");
                    System.out.println("\033[31m1. Bad Health\033[0m");
                    System.out.println("\033[31m2. Worst Health\033[0m");
                    System.out.println("\033[31m3. Close to Death\033[0m");
                    System.out.println("\033[31m4. Okay Health\033[0m");
                    System.out.print("Please choose an option: ");

                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character after reading an integer

                    // Map the option to the corresponding health status
                    String status = "";
                    switch (statusChoice) {
                        case 1:
                            status = "You are in bad health!";
                            break;
                        case 2:
                            status = "You are in worst health!!";
                            break;
                        case 3:
                            status = "You are close to DEATH!!!";
                            break;
                        case 4:
                            status = "Your health status is okay.";
                            break;
                        default:
                            status = "Invalid option. Please try again.";
                            break;
                    }

                    // Get suggestions based on the selected health status
                    String suggestions = suggestionService.generateSuggestions(status);

                    // Display suggestions in a chart-like format with green borders
                    displaySuggestionsChart(suggestions);

                    pauseBeforeReturning();  // Wait for user input before returning to the main menu
                    break;
                case 3:
                    // Call doctor recommendation service to display the chart
                    doctorRecommendationService.recommendDoctor(scanner);  // Pass the scanner for user input
                    pauseBeforeReturning();  // Wait for user input before returning to the main menu
                    break;
                case 4:
                    // Call the routine service to display the ideal routine
                    routineService.displayIdealRoutine();
                    pauseBeforeReturning();  // Wait for user input before returning to the main menu
                    break;
                case 5:
                    // Call the med and liquid tracker service to track medication and water intake
                    medLiquidTrackerService.trackMedAndLiquid(scanner);  // Pass the scanner for user input
                    pauseBeforeReturning();  // Wait for user input before returning to the main menu
                    break;
                case 0:
                    running = false;  // Exit the loop and end the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();  // Close the scanner object to avoid resource leaks
    }

    // Show the application name in the center with colored text, outer border, and a message in the corner
    private static void showApplicationName() {
        String redColor = "\033[31m";
        String greenColor = "\033[32m";
        String whiteColor = "\033[37m";  // White for the reset color
        String resetColor = "\033[0m";   // Reset color

        String[] asciiArt = {
                "---------------------------------------",
                "|                                     |",
                "|      " + redColor + "C R A C K E D" + resetColor + " - " + greenColor + "H E A L T H" + resetColor + "    |",
                "|                                     |",
                "---------------------------------------"
        };

        int consoleWidth = 80;
        int padding = (consoleWidth - asciiArt[2].length()) / 2;

        for (String line : asciiArt) {
            System.out.println(greenColor + line + resetColor);  // Print the border in green
        }

        String message = "Proceed only if you are in a bad health!!";
        System.out.println(redColor + "| " + message + " " + resetColor);
    }

    // Show the "Welcome to Cracked-Health!" message in green and options in blue
    private static void showWelcomeMessage() {
        String greenColor = "\033[32m";  // Green color ANSI code
        String blueColor = "\033[34m";    // Blue color ANSI code for question numbers
        String resetColor = "\033[0m";   // Reset color ANSI code

        // Display welcome message in green
        System.out.println(greenColor + "Welcome to Cracked-Health!" + resetColor);

        // Display options with numbering in blue
        System.out.println(blueColor + "1. Health Condition Checker" + resetColor);
        System.out.println(blueColor + "2. Suggestions to Revive" + resetColor);
        System.out.println(blueColor + "3. Doctor Recommendation" + resetColor);
        System.out.println(blueColor + "4. Ideal Routine" + resetColor);
        System.out.println(blueColor + "5. Med and Liquid Tracker" + resetColor);
        System.out.println(blueColor + "0. Exit" + resetColor);
    }

    // Function to display suggestions in a chart-like format with green-colored borders and white text inside
    private static void displaySuggestionsChart(String suggestions) {
        // Simple chart-like structure using ASCII with green box and white text inside
        String green = "\033[32m";  // Green color code for borders
        String white = "\033[37m";  // White color code for text
        String reset = "\033[0m";   // Reset color to default

        // Start chart with green border
        System.out.println("\n" + green + "Suggestions to Revive:" + reset);
        System.out.println(green + "+--------------------------------------------------+" + reset);
        System.out.println(green + "|                   Suggestions                    |" + reset);
        System.out.println(green + "+--------------------------------------------------+" + reset);

        // Loop through the suggestions and display them inside the green border, with white text
        String[] suggestionList = suggestions.split("\n");
        for (String suggestion : suggestionList) {
            System.out.println(green + "| " + white + suggestion + " " + green + "|" + reset);  // Display the suggestions in white text inside the green box
        }

        // Close the chart with green border
        System.out.println(green + "+--------------------------------------------------+" + reset);
    }

    // Pause before returning to the main menu
    private static void pauseBeforeReturning() {
        try {
            System.out.println("\nPress any key to return to the main menu...");
            System.in.read();  // Wait for user input (pressing any key)
            clearConsole();  // Clear the console before showing the main menu again
        } catch (Exception e) {
            System.out.println("Error while waiting for user input.");
        }
    }

    // Clear the console based on the operating system
    private static void clearConsole() {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        try {
            if (operatingSystem.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console.");
        }
    }
}
