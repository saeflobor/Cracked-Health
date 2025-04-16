import healthtracking.HealthConditionChecker;
import liquidtracking.LiquidTrackerService;
import medication.MedicineTrackerService;
import menu.MenuManager;
import suggetions.SuggestionService;
import routine.RoutineService;
import doctor.DoctorRecommendationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create service instances
        HealthConditionChecker healthChecker = new HealthConditionChecker();
        MedicineTrackerService medicineTracker = new MedicineTrackerService();
        LiquidTrackerService liquidTracker = new LiquidTrackerService();
        SuggestionService suggestionService = new SuggestionService();
        DoctorRecommendationService doctorRecommendationService = new DoctorRecommendationService();
        RoutineService routineService = new RoutineService();

        // Create and display the main menu
        MenuManager menuManager = new MenuManager(scanner, healthChecker, medicineTracker, liquidTracker, suggestionService, doctorRecommendationService, routineService);
        menuManager.displayMainMenu();

        scanner.close();  // Close the scanner object to avoid resource leaks
    }
}
