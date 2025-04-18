package medication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicineTrackerService {

    private String medicationName;
    private int morningDoses;
    private int noonDoses;
    private int nightDoses;
    private int morningDosesTaken;
    private int noonDosesTaken;
    private int nightDosesTaken;

    public MedicineTrackerService() {
        this.medicationName = "";
        this.morningDoses = 0;
        this.noonDoses = 0;
        this.nightDoses = 0;
        this.morningDosesTaken = 0;
        this.noonDosesTaken = 0;
        this.nightDosesTaken = 0;
    }

    // Set medication and doses
    public void setMedicationDetails(Scanner scanner) {
        System.out.print("Enter medication name: ");
        this.medicationName = scanner.nextLine();

        System.out.print("Enter the number of morning doses: ");
        this.morningDoses = scanner.nextInt();

        System.out.print("Enter the number of noon doses: ");
        this.noonDoses = scanner.nextInt();

        System.out.print("Enter the number of night doses: ");
        this.nightDoses = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after integer input

        System.out.println("\nMedication details updated successfully!");

        // Save medication details to CSV file
        saveMedicationToCSV();
    }

    // Track daily medicine consumption
    public void trackDailyMedicineConsumption(Scanner scanner) {
        // Read current medication details from CSV
        displayMedicationTracker();

        System.out.println("\nTrack your daily medicine consumption for " + medicationName);

        // Prompt user for how many doses have been taken
        System.out.print("How many morning doses have you taken? ");
        morningDosesTaken = scanner.nextInt();

        System.out.print("How many noon doses have you taken? ");
        noonDosesTaken = scanner.nextInt();

        System.out.print("How many night doses have you taken? ");
        nightDosesTaken = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Update the CSV file with the new doses taken
        saveDailyConsumptionToCSV();

        System.out.println("Daily consumption data updated!");
    }

    private void saveDailyConsumptionToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("medication_consumption.csv", true))) {
            writer.append(medicationName + ", " + morningDosesTaken + ", " + noonDosesTaken + ", " + nightDosesTaken + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public void displayMedicationTracker() {
        try (BufferedReader br = new BufferedReader(new FileReader("medication_records.csv"))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\n\033[31m<<<\033[32m Medication Tracker \033[31m>>>\033[32m");
            System.out.println("+----------------------------+-----------------+-----------------+-----------------+");
            System.out.println("|        Medication          |  Morning Doses  |   Noon Doses    |   Night Doses   |");
            System.out.println("+----------------------------+-----------------+-----------------+-----------------+");

            // Read the file and display the medication tracker
            while ((line = br.readLine()) != null) {
                hasRecords = true;
                String[] record = line.split(", ");
                if (record.length == 4) {
                    String medication = record[0];
                    int morning = Integer.parseInt(record[1]);
                    int noon = Integer.parseInt(record[2]);
                    int night = Integer.parseInt(record[3]);

                    System.out.println(String.format("\033[0m| %-27s| %-16d| %-16d| %-16d|", medication, morning, noon, night));
                }
            }

            if (!hasRecords) {
                System.out.println("|                       No medication records available.                           |");
            }

            System.out.println("\033[32m+----------------------------+-----------------+-----------------+-----------------+");
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Display daily consumption summary
    public void displayDailyConsumptionSummary() {
        try (BufferedReader br = new BufferedReader(new FileReader("medication_consumption.csv"))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\nDaily Medicine Consumption Summary:");
            System.out.println("+----------------------------+------------------+------------------+------------------+");
            System.out.println("| Medication                | Morning Doses    | Noon Doses       | Night Doses      |");
            System.out.println("+----------------------------+------------------+------------------+------------------+");

            while ((line = br.readLine()) != null) {
                hasRecords = true;
                String[] record = line.split(", ");
                if (record.length == 4) {
                    String medication = record[0];
                    int morning = Integer.parseInt(record[1]);
                    int noon = Integer.parseInt(record[2]);
                    int night = Integer.parseInt(record[3]);

                    System.out.println(String.format("| %-26s| %-16d| %-16d| %-16d|", medication, morning, noon, night));
                }
            }

            if (!hasRecords) {
                System.out.println("| No consumption records available. |");
            }

            System.out.println("+----------------------------+------------------+------------------+------------------+");
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Save medication details to CSV file
    private void saveMedicationToCSV() {
        try (FileWriter writer = new FileWriter("medication_records.csv", true)) {
            writer.append(medicationName + ", " + morningDoses + ", " + noonDoses + ", " + nightDoses + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    public void updateDoses(Scanner scanner) {
        // Ask user to update morning, noon, and night doses
        System.out.print("Enter the new number of morning doses for " + medicationName + ": ");
        morningDoses = scanner.nextInt();

        System.out.print("Enter the new number of noon doses for " + medicationName + ": ");
        noonDoses = scanner.nextInt();

        System.out.print("Enter the new number of night doses for " + medicationName + ": ");
        nightDoses = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after integer input

        // Save updated doses to the CSV file
        saveMedicationToCSV();

        System.out.println("Medication doses updated successfully!");
    }
}
