package routine;

public class RoutineService {


    public void displayIdealRoutine() {
        String yellow = "\033[33m";  // Yellow color code for borders and text
        String white = "\033[37m";   // White color code for text inside the chart
        String reset = "\033[0m";    // Reset color code to default


        System.out.println(yellow + "+----------------------------------------------+" + reset);
        System.out.println(yellow + "|           Ideal Health Routine               |" + reset);
        System.out.println(yellow + "+----------------------------------------------+" + reset);


        System.out.println(yellow + "| 1. Sleep     : 12 am - 7 am                  |" + white + "  (7 hours)" + reset);
        System.out.println(yellow + "| 2. Breakfast : Eggs, Milk, Fruit             |" + white + "  (Protein & Vitamins)" + reset);
        System.out.println(yellow + "| 3. Lunch     : 150 gm Protein, Rice, Lentils |" + white + "  (High Protein & Fiber)" + reset);
        System.out.println(yellow + "| 4. Dinner    : 120 gm Protein, Vegetables    |" + white + "  (Balanced Diet)" + reset);
        System.out.println(yellow + "| 5. Drink     : At least 2 liters of water    |" + white + "  (Hydration)" + reset);
        System.out.println(yellow + "| 6. Exercise  : 30 minutes daily              |" + white + "  (Physical Activity)" + reset);


        System.out.println(yellow + "+----------------------------------------------+" + reset);
    }
}
