package menu;

import medication.MedicineTrackerService;
import utils.TerminalUtils;

import java.util.Scanner;
import java.io.*;

public class MedicineMenu {

    private Scanner scanner;
    private MedicineTrackerService medicineTracker;

    public MedicineMenu(Scanner scanner, MedicineTrackerService medicineTracker) {
        this.scanner = scanner;
        this.medicineTracker = medicineTracker;
    }

    public void displayMedicineMenu() {
        boolean submenuRunning = true;
        while (submenuRunning) {
            TerminalUtils.clearScreen();  // Clear the terminal before showing the submenu
            System.out.println("\nMedicine Tracker Menu:");
            System.out.println("1. Set Medication Details");
            System.out.println("2. Update Medication Doses");
            System.out.println("3. View Medication Tracker");
            System.out.println("4. Track Daily Medicine Consumption");
            System.out.println("5. View Daily Medicine Consumption Summary");
            System.out.println("0. Back to Main Menu");

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    medicineTracker.setMedicationDetails(scanner);  // Set medication details
                    break;
                case 2:
                    updateMedicationDoses();  // Update medication doses
                    break;
                case 3:
                    medicineTracker.displayMedicationTracker();  // Display medication tracker
                    break;
                case 4:
                    medicineTracker.trackDailyMedicineConsumption(scanner);  // Track daily medicine consumption
                    break;
                case 5:
                    medicineTracker.displayDailyConsumptionSummary();  // View daily medicine consumption summary
                    break;
                case 0:
                    submenuRunning = false;  // Go back to the main menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to update the doses of a selected medicine
    private void updateMedicationDoses() {
        // Display all the current medication records
        File medicationFile = new File("medication_records.csv");

        if (!medicationFile.exists()) {
            System.out.println("No medication records found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(medicationFile))) {
            String line;
            int counter = 1;
            System.out.println("\nSelect a medication to update its doses:");
            System.out.println("+------------------------------------+-----------------+-----------------+-----------------+");
            System.out.println("| Medication                        | Morning Doses   | Noon Doses      | Night Doses     |");
            System.out.println("+------------------------------------+-----------------+-----------------+-----------------+");

            // Read and display all the medicines
            while ((line = reader.readLine()) != null) {
                String[] medicationData = line.split(", ");
                if (medicationData.length == 4) {
                    System.out.println(String.format("| %-34s| %-16s| %-16s| %-16s|", medicationData[0], medicationData[1], medicationData[2], medicationData[3]));
                    counter++;
                }
            }

            System.out.println("+------------------------------------+-----------------+-----------------+-----------------+");

            System.out.print("Enter the number corresponding to the medication you want to update: ");
            int selectedMedicineIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Read the file again to find the selected medicine and update the doses
            reader.close();

            // Load all medications into a list to easily update
            BufferedReader readerForUpdate = new BufferedReader(new FileReader(medicationFile));
            StringBuilder updatedContent = new StringBuilder();
            counter = 1;
            String selectedMedication = "";
            String[] selectedMedicineData = null;

            while ((line = readerForUpdate.readLine()) != null) {
                String[] medicationData = line.split(", ");
                if (medicationData.length == 4) {
                    if (counter == selectedMedicineIndex) {
                        selectedMedication = medicationData[0];
                        selectedMedicineData = medicationData;
                    }
                    counter++;
                }
            }

            if (selectedMedicineData == null) {
                System.out.println("Invalid selection!");
                return;
            }

            // Display current dosage and ask for updates
            System.out.println("\nCurrent doses for " + selectedMedication + ":");
            System.out.println("Morning: " + selectedMedicineData[1]);
            System.out.println("Noon: " + selectedMedicineData[2]);
            System.out.println("Night: " + selectedMedicineData[3]);

            // Prompt user to enter new doses
            System.out.print("Enter new morning dose: ");
            String newMorningDose = scanner.nextLine();

            System.out.print("Enter new noon dose: ");
            String newNoonDose = scanner.nextLine();

            System.out.print("Enter new night dose: ");
            String newNightDose = scanner.nextLine();

            // Update the record with new doses
            String updatedLine = selectedMedicineData[0] + ", " + newMorningDose + ", " + newNoonDose + ", " + newNightDose + "\n";

            // Rewrite the entire file with updated doses
            readerForUpdate.close();
            BufferedReader readerForRewrite = new BufferedReader(new FileReader(medicationFile));

            while ((line = readerForRewrite.readLine()) != null) {
                String[] medicationData = line.split(", ");
                if (medicationData[0].equals(selectedMedication)) {
                    updatedContent.append(updatedLine);  // Update the line with new doses
                } else {
                    updatedContent.append(line).append("\n");
                }
            }

            // Write the updated content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(medicationFile))) {
                writer.write(updatedContent.toString());
            }

            System.out.println("\nMedication doses updated successfully!");

        } catch (IOException e) {
            System.out.println("Error while updating medication doses: " + e.getMessage());
        }
    }
}
