import java.util.Scanner;

public class DoctorRecommendationService {

    public void recommendDoctor(Scanner scanner) {

        displayDoctorChart();
    }

    private void displayDoctorChart() {
        String green = "\033[32m";  // Green color code for borders
        String white = "\033[37m";  // White color code for text
        String reset = "\033[0m";   // Reset color to default


        System.out.println(green + "+------------------------+-------------------------+" + reset);
        System.out.println(green + "| Symptom                | Doctor Recommendation   |" + reset);
        System.out.println(green + "+------------------------+-------------------------+" + reset);


        String[] symptoms = {"Headache", "Chest Pain", "Body Pain", "Stomach Ache", "Cough"};
        String[] doctors = {"Neurologist", "Cardiologist", "Orthopedic", "Gastroenterologist", "Pulmonologist"};


        for (int i = 0; i < symptoms.length; i++) {
            System.out.println(green + "| " + white + padString(symptoms[i], 24) + green + "| " + white + padString(doctors[i], 23) + green + "|" + reset);
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
