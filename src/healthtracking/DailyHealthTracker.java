package healthtracking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
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
        try (BufferedReader br = new BufferedReader(new FileReader("health_records.csv"))) {
            String line;
            boolean hasRecords = false;

            System.out.println("\n\033[31m<<<\033[0m Your Daily Health Track \033[31m>>>\033[32m");
            System.out.println("+---------------------------+-------------------------+");
            System.out.println("| Date and Time             | Health Status           |");
            System.out.println("+---------------------------+-------------------------+");

            // Read through the file and print each line
            while ((line = br.readLine()) != null) {
                hasRecords = true;
                System.out.println("| \033[00m" + line + "      \033[32m|");
                
            }

            if (!hasRecords) {
                System.out.println("|                No health records available           |");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }

            System.out.println("+---------------------------+-------------------------+");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
}
