package menu;

import healthtracking.HealthConditionChecker;
import liquidtracking.LiquidTrackerService;
import medication.MedicineTrackerService;
import suggetions.SuggestionService;
import routine.RoutineService;
import doctor.DoctorRecommendationService;
import utils.TerminalUtils;

import java.util.Scanner;

public class MenuManager {

    private Scanner scanner;
    private HealthConditionChecker healthChecker;
    private MedicineTrackerService medicineTracker;
    private LiquidTrackerService liquidTracker;
    private SuggestionService suggestionService;
    private DoctorRecommendationService doctorRecommendationService;
    private RoutineService routineService;

    public MenuManager(Scanner scanner, HealthConditionChecker healthChecker, MedicineTrackerService medicineTracker,
                       LiquidTrackerService liquidTracker, SuggestionService suggestionService,
                       DoctorRecommendationService doctorRecommendationService, RoutineService routineService) {
        this.scanner = scanner;
        this.healthChecker = healthChecker;
        this.medicineTracker = medicineTracker;
        this.liquidTracker = liquidTracker;
        this.suggestionService = suggestionService;
        this.doctorRecommendationService = doctorRecommendationService;
        this.routineService = routineService;
    }

    public void displayMainMenu() {
        boolean running = true;
        while (running) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
            showApplicationName();
            showWelcomeMessage();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    new HealthStatusMenu(scanner, healthChecker).displayHealthStatusMenu();
                    break;
                case 2:
                    // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    handleSuggestions();
                    break;
                case 3:
                // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    doctorRecommendationService.recommendDoctor(scanner);
                    break;
                case 4:
                // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    routineService.displayIdealRoutine();
                    break;
                case 5:
                // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    new MedicineMenu(scanner, medicineTracker).displayMedicineMenu();  // Medicine menu
                    break;
                case 6:
                // TerminalUtils.clearScreen();  // Clear the terminal before showing the menu
                    // showApplicationName();
                    new LiquidMenu(scanner, liquidTracker).displayLiquidMenu();  // Liquid menu
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleSuggestions() {
        System.out.println("\nSelect your health status from the following options:");
        System.out.println("1. Bad Health");
        System.out.println("2. Worst Health");
        System.out.println("3. Close to Death");
        System.out.println("4. Okay Health");
        System.out.print("Please choose an option: ");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String status = getHealthStatus(statusChoice);
        String suggestions = suggestionService.generateSuggestions(status);
        displaySuggestionsChart(suggestions);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private String getHealthStatus(int choice) {
        switch (choice) {
            case 1:
                return "You are in bad health!";
            case 2:
                return "You are in worst health!!";
            case 3:
                return "You are close to DEATH!!!";
            case 4:
                return "Your health status is okay.";
            default:
                return "Invalid option.";
        }
    }

    private void displaySuggestionsChart(String suggestions) {
        System.out.println("\nSuggestions to Revive:");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                   Suggestions                   |");
        System.out.println("+--------------------------------------------------+");
        String[] suggestionList = suggestions.split("\n");
        for (String suggestion : suggestionList) {
            System.out.println("| " + suggestion + " |");
        }
        System.out.println("+--------------------------------------------------+");
    }

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
        System.out.println(blueColor + "5. Medicine Tracker" + resetColor);
        System.out.println(blueColor + "6. Liquid Tracker" + resetColor);
        System.out.println(blueColor + "0. Exit" + resetColor);
    }
}
