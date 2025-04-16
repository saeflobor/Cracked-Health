package suggetions;

public class SuggestionService {

    public String generateSuggestions(String healthStatus) {
        switch (healthStatus) {
            case "You are close to DEATH!!!":
                return  "1. Consult a doctor immediately.\n" +
                        "2. Need proper meals (3 times).\n" +
                        "3. Drink enough liquid.          ";
            case "You are in worst health!!":
                return  "1. You should get at least 6 hours of sleep.\n" +
                        "2. Need proper meals (3 times).             \n" +
                        "3. Consult a doctor.                          ";
            case "You are in bad health!":
                return  "1. Get at least 6 hours of sleep.\n" +
                        "2. Try to consume 3 meals.";
            default:
                return "You seem to be in okay health. Continue your normal routine.";
        }
    }

    // Function to display suggestions in a chart-like format with green-colored borders and white text inside
    public void displaySuggestionsChart(String suggestions) {
        // Simple chart-like structure using ASCII with green box and white text inside
        String green = "\033[32m";  // Green color code for borders
        String white = "\033[37m";  // White color code for text
        String reset = "\033[0m";   // Reset color to default

        // Start chart with green border
        System.out.println("\n" + green + "Suggestions to Revive:" + reset);
        System.out.println(green + "+--------------------------------------------------+" + reset);
        System.out.println(green + "|                   Suggestions                   |" + reset);
        System.out.println(green + "+--------------------------------------------------+" + reset);

        // Loop through the suggestions and display them inside the green border, with white text
        String[] suggestionList = suggestions.split("\n");
        for (String suggestion : suggestionList) {
            System.out.println(green + "| " + white + suggestion + " " + green + "|" + reset);  // Display the suggestions in white text inside the green box
        }

        // Close the chart with green border
        System.out.println(green + "+--------------------------------------------------+" + reset);
    }
}
