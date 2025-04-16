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
    }

    // Display medication tracker
    public void displayMedicationTracker() {
        System.out.println("\n" + "\033[32m" + "Medication Tracker:" + "\033[0m");
        System.out.println("+----------------------------+-----------------+");
        System.out.println("| Medication                | Doses Remaining |");
        System.out.println("+----------------------------+-----------------+");
        System.out.println(String.format("| %-26s| %-15d |", "Morning", morningDoses));
        System.out.println(String.format("| %-26s| %-15d |", "Noon", noonDoses));
        System.out.println(String.format("| %-26s| %-15d |", "Night", nightDoses));
        System.out.println("+----------------------------+-----------------+");
    }
}
