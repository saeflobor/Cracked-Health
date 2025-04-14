public class HealthConditionService {

    public String evaluateCondition(HealthCondition condition) {
        if (condition.getSleepHours() <= 1 && condition.getMeals() == 1 && condition.isDizzy()
                && condition.isTummyPain() && condition.isChestPain()) {
            return "You are close to DEATH!!!";
        } else if ((condition.getSleepHours() <= 3 || condition.getMeals() <= 2)
                && (condition.isDizzy() || condition.isTummyPain() || condition.isChestPain())) {
            return "You are in worst health!!";
        } else if (condition.getSleepHours() >= 4 && condition.getMeals() >= 2
                && (condition.isDizzy() || condition.isTummyPain())) {
            return "You are in bad health!";
        }
        return "Your health status is okay.";
    }
}
