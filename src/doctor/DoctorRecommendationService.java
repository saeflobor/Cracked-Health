package doctor;

import java.util.Scanner;

import utils.TerminalUtils;

public class DoctorRecommendationService {

    public void recommendDoctor(Scanner scanner) {

        displayDoctorChart();
        System.out.println("Press any key to continue...");
        Scanner scanner2 = new Scanner(System.in);
        scanner2.nextLine();
    }

    private void displayDoctorChart() {
        TerminalUtils terminalUtils = new TerminalUtils();
        terminalUtils.clearScreen();
        terminalUtils.showApplicationName();
        String green = "\033[32m";  // Green color code for borders
        String white = "\033[37m";  // White color code for text
        String reset = "\033[0m";   // Reset color to default


        System.out.println(green + "\n+------------------------+-------------------------+" + reset);
        System.out.println(green + "| Symptom                | Doctor Recommendation   |" + reset);
        System.out.println(green + "+------------------------+-------------------------+" + reset);


        String[] symptoms = {"Headache", "Chest Pain", "Body Pain", "Stomach Ache", "Cough", "No sure"};
        String[] doctors = {"Neurologist", "Cardiologist", "Orthopedic", "Gastroenterologist", "Pulmonologist", "Medicine"};


        for (int i = 0; i < symptoms.length; i++) {
            System.out.println(green + "| " + "\033[0m" + padString(symptoms[i], 23) + green + "| " + "\033[0m" + padString(doctors[i], 24) + green + "|" + reset);
        }


        System.out.println(green + "+------------------------+-------------------------+" + reset);
    }


    private String padString(String str, int length) {
        StringBuilder paddedString = new StringBuilder(str);
        while (paddedString.length() < length) {
            paddedString.append(" ");
        }
        return paddedString.toString();
    }
}
