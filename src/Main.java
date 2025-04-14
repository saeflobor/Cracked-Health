import java.util.Scanner;

public class Main {


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
}

    // Function to display suggestions in a chart-like format with green-colored borders and white text inside