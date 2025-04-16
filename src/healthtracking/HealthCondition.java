package healthtracking;

import java.util.Scanner;

public class HealthCondition {

    private int sleepHours;
    private int meals;
    private boolean dizzy;
    private boolean tummyPain;
    private boolean chestPain;

    // Constructor to initialize the health condition
    public HealthCondition(int sleepHours, int meals, boolean dizzy, boolean tummyPain, boolean chestPain) {
        this.sleepHours = sleepHours;
        this.meals = meals;
        this.dizzy = dizzy;
        this.tummyPain = tummyPain;
        this.chestPain = chestPain;
    }

    // Getters
    public int getSleepHours() {
        return sleepHours;
    }

    public int getMeals() {
        return meals;
    }

    public boolean isDizzy() {
        return dizzy;
    }

    public boolean isTummyPain() {
        return tummyPain;
    }

    public boolean isChestPain() {
        return chestPain;
    }
}
