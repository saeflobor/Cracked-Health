import java.util.Scanner;

public class HealthStatusService {

    private final ISuggestionService suggestionService;

    public HealthStatusService(ISuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    public String checkHealthCondition(Scanner scanner) {
        System.out.println("How many hours do you sleep at night?");
        System.out.println("1. 0-1 hours");
        System.out.println("2. 2-3 hours");
        System.out.println("3. 4-5 hours");
        System.out.println("4. More than 5 hours");
        System.out.print("Please choose an option: ");
        int sleepOption = scanner.nextInt();

        System.out.println("How many meals do you take in a day?");
        System.out.println("1. 1 meal");
        System.out.println("2. 2 meals");
        System.out.println("3. 3 meals");
        System.out.print("Please choose an option: ");
        int mealsOption = scanner.nextInt();

        // Evaluate health condition based on responses
        return evaluateHealthStatus(sleepOption, mealsOption);
    }

    public void showSuggestions(Scanner scanner) {
        System.out.println("\nSelect your health status from the following options:");
        System.out.println("1. Bad Health");
        System.out.println("2. Worst Health");
        System.out.println("3. Close to Death");
        System.out.println("4. Okay Health");
        System.out.print("Please choose an option: ");

        int statusChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String status = getHealthStatusFromChoice(statusChoice);
        String suggestions = suggestionService.generateSuggestions(status);
        displaySuggestionsChart(suggestions);
    }

    private String getHealthStatusFromChoice(int statusChoice) {
        switch (statusChoice) {
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

    private String evaluateHealthStatus(int sleepOption, int mealsOption) {
        if (sleepOption == 1 && mealsOption == 1) {
            return "You are close to DEATH!!!";
        } else if (sleepOption == 2 || mealsOption == 2) {
            return "You are in worst health!!";
        }
        return "Your health status is okay.";
    }

    private void displaySuggestionsChart(String suggestions) {
        System.out.println("\n" + "\033[32m" + "Suggestions to Revive:" + "\033[0m");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                   Suggestions                   |");
        System.out.println("+--------------------------------------------------+");
        String[] suggestionList = suggestions.split("\n");
        for (String suggestion : suggestionList) {
            System.out.println("| " + suggestion + " |");
        }
        System.out.println("+--------------------------------------------------+");
    }
}
