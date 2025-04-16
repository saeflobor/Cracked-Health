import java.io.FileWriter;
import java.io.IOException;
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
        System.out.print("\nUpdate the number of morning doses: ");
        this.morningDoses = scanner.nextInt();

        System.out.print("Update the number of noon doses: ");
        this.noonDoses = scanner.nextInt();

        System.out.print("Update the number of night doses: ");
        this.nightDoses = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.println("\nMedication doses updated successfully!");

        // Save updated medication details to CSV file
        saveMedicationToCSV();
    }

    // Display medication tracker
    public void displayMedicationTracker() {
        if (medicationName.isEmpty()) {
            System.out.println("\nNo medication records available.");
            return;
        }

        System.out.println("\n" + "\033[32m" + "Medication Tracker:" + "\033[0m");
        System.out.println("+----------------------------+-----------------+");
        System.out.println("| Medication                | Doses Remaining |");
        System.out.println("+----------------------------+-----------------+");
        System.out.println(String.format("| %-26s| %-15d |", medicationName + " (Morning)", morningDoses));
        System.out.println(String.format("| %-26s| %-15d |", medicationName + " (Noon)", noonDoses));
        System.out.println(String.format("| %-26s| %-15d |", medicationName + " (Night)", nightDoses));
        System.out.println("+----------------------------+-----------------+");
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
