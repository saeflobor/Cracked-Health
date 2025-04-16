import java.util.Scanner;

public class HealthConditionChecker {

    private static final String PURPLE = "\033[35m";
    private static final String RESET = "\033[0m";
    DailyHealthTracker dailyHealthTracker;

    public HealthConditionChecker() {
        this.dailyHealthTracker = new DailyHealthTracker();
    }

    public String checkHealthCondition(Scanner scanner) {
        // Ask the user questions and capture their answers
        System.out.println(PURPLE + "How many hours do you sleep at night?" + RESET);
        System.out.println("1. 0-1 hours");
        System.out.println("2. 2-3 hours");
        System.out.println("3. 4-5 hours");
        System.out.println("4. More than 5 hours");
        System.out.print("Please choose an option: ");
        int sleepOption = scanner.nextInt();
        System.out.println();

        System.out.println(PURPLE + "How many meals do you take in a day?" + RESET);
        System.out.println("1. 1 meal");
        System.out.println("2. 2 meals");
        System.out.println("3. 3 meals");
        System.out.print("Please choose an option: ");
        int mealsOption = scanner.nextInt();
        System.out.println();

        System.out.println(PURPLE + "Do you feel Dizzy?" + RESET);
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Please choose an option: ");
        boolean dizzy = scanner.nextInt() == 1;
        System.out.println();

        System.out.println(PURPLE + "Does your tummy hurt and you vomited?" + RESET);
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Please choose an option: ");
        boolean tummyPain = scanner.nextInt() == 1;
        System.out.println();

        System.out.println(PURPLE + "Do you have chest and body pain?" + RESET);
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Please choose an option: ");
        boolean chestPain = scanner.nextInt() == 1;
        System.out.println();

        // Evaluate health status based on responses
        String healthStatus = evaluateHealthStatus(sleepOption, mealsOption, dizzy, tummyPain, chestPain);

        // Display health status
        System.out.println("\n\033[31mHealth Status: " + healthStatus + "\033[0m");

        // Record the health status for tracking
        dailyHealthTracker.recordHealthStatus(healthStatus);

        // Prompt the user to return to the main menu
        System.out.println("\nPress 0 to go back to the main menu or 1 to view daily health track.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return healthStatus;
        } else if (choice == 1) {
            dailyHealthTracker.showDailyTrack(); // Show the daily health track
        }

        return healthStatus;
    }

    private String evaluateHealthStatus(int sleepOption, int mealsOption, boolean dizzy, boolean tummyPain, boolean chestPain) {
        if (sleepOption == 1 && mealsOption == 1 && dizzy && tummyPain && chestPain) {
            return "You are close to DEATH!!!";
        } else if ((sleepOption == 1 || sleepOption == 2) && (mealsOption == 1 || mealsOption == 2) && (dizzy || tummyPain || chestPain)) {
            return "You are in worst health!!";
        } else if (sleepOption == 3 || mealsOption == 3) {
            return "You are in bad health!";
        }
        return "Your health status is okay.";
    }
}
