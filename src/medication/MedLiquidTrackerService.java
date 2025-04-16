package medication;

import java.util.Scanner;

public class MedLiquidTrackerService {


    public void trackMedAndLiquid(Scanner scanner) {

        System.out.println("Enter medication name:");
        String medName = scanner.nextLine();  // Read the medication name


        int morningDoses = getDoseInput(scanner, "Morning");
        int noonDoses = getDoseInput(scanner, "Noon");
        int nightDoses = getDoseInput(scanner, "Night");


        String medicationTracking = trackMedication(medName, morningDoses, noonDoses, nightDoses);
        System.out.println(medicationTracking);


        System.out.println("\nNow, let's track your water consumption.");


        int waterConsumed = getWaterInput(scanner, "Water Consumed");
        int dailyGoal = getWaterInput(scanner, "Daily Water Goal");


        String waterTracking = trackWaterIntake(waterConsumed, dailyGoal);
        System.out.println(waterTracking);
    }


    private int getDoseInput(Scanner scanner, String timeOfDay) {
        System.out.println("How many doses of medication for " + timeOfDay + "?");
        System.out.print("Please enter the number of doses: ");
        return scanner.nextInt();
    }


    private int getWaterInput(Scanner scanner, String waterType) {
        System.out.println("Enter the " + waterType + " (in ml):");
        return scanner.nextInt();
    }


    public String trackMedication(String medName, int morningDoses, int noonDoses, int nightDoses) {
        // Return the medication details in a structured chart-like format with blue color
        return displayMedicationChart(medName, morningDoses, noonDoses, nightDoses);
    }


    private String displayMedicationChart(String medName, int morningDoses, int noonDoses, int nightDoses) {
        String blue = "\033[34m";  // Blue color code for borders and text
        String reset = "\033[0m";  // Reset color to default


        String chart = blue + "+-------------------------+------------------+" + reset + "\n";
        chart += blue + "| Medication              | Doses Remaining  |" + reset + "\n";
        chart += blue + "+-------------------------+------------------+" + reset + "\n";
        chart += String.format(blue + "| %-23s| %-16d |" + reset + "\n", "Morning", morningDoses);
        chart += String.format(blue + "| %-23s| %-16d |" + reset + "\n", "Noon", noonDoses);
        chart += String.format(blue + "| %-23s| %-16d |" + reset + "\n", "Night", nightDoses);
        chart += blue + "+-------------------------+------------------+" + reset + "\n";

        return chart;
    }


    public String trackWaterIntake(int waterConsumed, int dailyGoal) {
        String waterMessage;
        String waterStatus = "\033[32m"; // Green color for positive feedback

        if (waterConsumed >= dailyGoal) {

            waterMessage = waterStatus + "\nAwesome! You've met your daily water goal of " + dailyGoal + " ml!\n" ;
        } else {

            int remainingWater = dailyGoal - waterConsumed;
            waterMessage = "\n\033[31mYou have consumed " + waterConsumed + " ml of water.\033[0m\n" +
                    "You still need \033[33m" + remainingWater + " ml\033[0m to reach your daily goal of " + dailyGoal + " ml.";
        }
        return waterMessage;
    }
}
