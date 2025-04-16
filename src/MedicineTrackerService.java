import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicineTrackerService {

    private String medicationName;
    private int morningDoses;
    private int noonDoses;
    private int nightDoses;

    public MedicineTrackerService() {
        this.medicationName = "";
        this.morningDoses = 0;
        this.noonDoses = 0;
        this.nightDoses = 0;
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

    // Update medication doses

    public void updateDoses(Scanner scanner) {
        // Step 1: Read existing medication records
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("medication_records.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(", ");
                records.add(record);
            }
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
            return;
        }

        // Step 2: Ask user for the medication to update
        System.out.println("\nEnter the medication name to update:");
        String medicationName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < records.size(); i++) {
            String[] record = records.get(i);
            if (record[0].equals(medicationName)) {
                // Medication found, update the doses
                System.out.println("Updating medication doses for: " + medicationName);

                System.out.print("Enter the number of morning doses: ");
                int morningDoses = scanner.nextInt();

                System.out.print("Enter the number of noon doses: ");
                int noonDoses = scanner.nextInt();

                System.out.print("Enter the number of night doses: ");
                int nightDoses = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                // Update the record with new doses
                record[1] = String.valueOf(morningDoses);
                record[2] = String.valueOf(noonDoses);
                record[3] = String.valueOf(nightDoses);

                // Update the list of records
                records.set(i, record);
                found = true;
                break;
            }
        }

        if (found) {
            // Step 3: Write the updated records back to the CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("medication_records.csv"))) {
                for (String[] record : records) {
                    writer.write(String.join(", ", record));
                    writer.newLine();
                }
                System.out.println("Medication doses updated successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to CSV file: " + e.getMessage());
            }
        } else {
            System.out.println("Medication not found. Please check the name and try again.");
        }
    }


    // Display medication tracker

    public void displayMedicationTracker() {
        try (BufferedReader br = new BufferedReader(new FileReader("medication_records.csv"))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\nMedication Tracker:");
            System.out.println("+----------------------------+-----------------+");
            System.out.println("| Medication                | Doses Remaining |");
            System.out.println("+----------------------------+-----------------+");

            // Read through the file and print each medication and its doses
            while ((line = br.readLine()) != null) {
                hasRecords = true;
                String[] record = line.split(", ");
                if (record.length == 4) {
                    String medication = record[0];
                    int morningDoses = Integer.parseInt(record[1]);
                    int noonDoses = Integer.parseInt(record[2]);
                    int nightDoses = Integer.parseInt(record[3]);

                    // Display the medication and remaining doses
                    System.out.println(String.format("| %-26s| %-15d |", medication + " (Morning)", morningDoses));
                    System.out.println(String.format("| %-26s| %-15d |", medication + " (Noon)", noonDoses));
                    System.out.println(String.format("| %-26s| %-15d |", medication + " (Night)", nightDoses));
                }
            }

            if (!hasRecords) {
                System.out.println("| No medication records available. |");
            }

            System.out.println("+----------------------------+-----------------+");
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
    }


    // Save medication details to CSV file
    private void saveMedicationToCSV() {
        try (FileWriter writer = new FileWriter("medication_records.csv", true)) {
            writer.append(medicationName + ", " + morningDoses + ", " + noonDoses + ", " + nightDoses + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
