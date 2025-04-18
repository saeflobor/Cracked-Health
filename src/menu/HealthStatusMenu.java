package menu;

import healthtracking.HealthConditionChecker;
import utils.TerminalUtils;

import java.util.Scanner;

import static java.awt.Color.green;

public class HealthStatusMenu {

    private Scanner scanner;
    private HealthConditionChecker healthChecker;

    public HealthStatusMenu(Scanner scanner, HealthConditionChecker healthChecker) {
        this.scanner = scanner;
        this.healthChecker = healthChecker;
    }

    public void displayHealthStatusMenu() {
        TerminalUtils terminalUtils = new TerminalUtils();
        terminalUtils.clearScreen();
        terminalUtils.showApplicationName();
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            System.out.println("\033[31m\n<<<\033[32m Health Condition Checker Menu \033[31m>>>\n\033[0m");
            System.out.println("\033[31m1.\033[0m Check Health Condition");
            System.out.println("\033[31m2.\033[0m View Daily Health Track");
            System.out.println("\033[31m0.\033[0m Back to Main Menu");

            System.out.print("\nPlease choose an option: ");
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
}
