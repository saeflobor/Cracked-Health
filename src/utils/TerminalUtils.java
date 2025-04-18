package utils;

import java.io.IOException;

public class TerminalUtils {

    // Clear the terminal screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void showApplicationName() {
        String redColor = "\033[31m";
        String greenColor = "\033[32m";
        String whiteColor = "\033[37m";  // White for the reset color
        String resetColor = "\033[0m";   // Reset color

        String[] asciiArt = {
                "---------------------------------------",
                "|                                     |",
                "|      " + redColor + "C R A C K E D" + greenColor + " - H E A L T H" + "    |",
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
}
