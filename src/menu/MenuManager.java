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
            System.out.print("\nPlease select an option: ");
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
        System.out.println("\n\033[31m<<<\033[32m Select your health status from the following options \033[31m>>>\n\033[0m");
        System.out.println("\033[31m1.\033[00m Bad Health");
        System.out.println("\033[31m2.\033[00m Worst Health");
        System.out.println("\033[31m3.\033[00m Close to Death");
        System.out.println("\033[31m4.\033[00m Okay Health");
        System.out.print("\nPlease choose an option: ");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String status = getHealthStatus(statusChoice);
        String suggestions = suggestionService.generateSuggestions(status);
        displaySuggestionsChart(suggestions);
        System.out.println("Press any key to continue...");
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
        System.out.println("\033[32m\nSuggestions to Revive:\033[00m");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                   Suggestions                    |");
        System.out.println("+--------------------------------------------------+");
        String[] suggestionList = suggestions.split("\n");
        for (String suggestion : suggestionList) {
            System.out.println("\033[32m| " + suggestion);
        }
        System.out.println("\033[00m+--------------------------------------------------+");
    }

    private static void showApplicationName() {
        String redColor = "\033[31m";
        String greenColor = "\033[32m";
        String whiteColor = "\033[37m";  // White for the reset color
        String resetColor = "\033[0m";   // Reset color

        String[] asciiArt = {
                "---------------------------------------",
                "|                                     |",
                "|      " + redColor + "C R A C K E D " + greenColor + "- H E A L T H" + "    |",
                "|                                     |",
                "---------------------------------------"
        };

        int consoleWidth = 80;
        int padding = (consoleWidth - asciiArt[2].length()) / 2;

        for (String line : asciiArt) {
            System.out.println(greenColor + line + resetColor);  // Print the border in green
        }

        String message = "Proceed only if you are in a bad health!!";
        System.out.println(redColor + "| " + message + " |" + resetColor);
    }

    // Show the "Welcome to Cracked-Health!" message in green and options in blue
    private static void showWelcomeMessage() {
        String greenColor = "\033[32m";  // Green color ANSI code
        String blueColor = "\033[34m";    // Blue color ANSI code for question numbers
        String resetColor = "\033[0m";   // Reset color ANSI code

        // Display welcome message in green
        System.out.println(greenColor + "\n\033[31m<<<\033[32m Welcome to Cracked-Health! \033[31m>>>\n" + resetColor);

        // Display options with numbering in blue
        System.out.println("\033[31m1.\033[0m Health Condition Checker");
        System.out.println("\033[31m2.\033[0m Suggestions to Revive");
        System.out.println("\033[31m3.\033[0m Doctor Recommendation");
        System.out.println("\033[31m4.\033[0m Ideal Routine");
        System.out.println("\033[31m5.\033[0m Medicine Tracker");
        System.out.println("\033[31m6.\033[0m Liquid Tracker");
        System.out.println("\033[31m0.\033[0m Exit");
    }
}
