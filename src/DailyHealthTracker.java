import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DailyHealthTracker {

    private List<String> dailyHealthRecords;

    public DailyHealthTracker() {
        this.dailyHealthRecords = new ArrayList<>();
    }

    // Record health status along with the date and time
    public void recordHealthStatus(String healthStatus) {
        String currentDateTime = getCurrentDateTime();
        String record = currentDateTime + ", " + healthStatus;
        dailyHealthRecords.add(record);
        saveHealthRecordToCSV(currentDateTime, healthStatus);
    }

    // Get current date and time in "YYYY-MM-DD HH:mm:ss" format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // Save health status along with date and time to CSV file
    private void saveHealthRecordToCSV(String dateTime, String healthStatus) {
        try (FileWriter writer = new FileWriter("health_records.csv", true)) {
            writer.append(dateTime + ", " + healthStatus + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    // Show the daily health track (history of recorded health statuses)
    public void showDailyTrack() {
        if (dailyHealthRecords.isEmpty()) {
            System.out.println("No health records available.");
            return;
        }

        System.out.println("\n" + "\033[32m" + "Your Daily Health Track:" + "\033[0m");
        System.out.println("+---------------------------+");
        System.out.println("| Date and Time             | Health Status           |");
        System.out.println("+---------------------------+");

        for (String record : dailyHealthRecords) {
            System.out.println("| " + record + " |");
        }
        System.out.println("+---------------------------+");
    }
}
