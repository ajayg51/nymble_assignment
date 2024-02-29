package com.example.nymble_assignment.file_system;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.utils.Print;

public class DestinationFileHandling {
    private String destinationFilePath = "destination.txt";

    public String getDestinationFilePath() {
        return this.destinationFilePath;
    }

    public void readDestinationFile() {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Read :: Inside Destination file");
        Print.println();
        Print.println();
        Print.println();
        try {
            List<String> allReadLines = Files.readAllLines(Paths.get(getDestinationFilePath()));
            Print.println();
            Print.println();
            Print.print("Read :: destination file successfully");
            Print.println();
            Print.println();
            for (String line : allReadLines) {
                Print.print(line);
                Print.println();
                Print.println();
            }
        } catch (Exception e) {
            Print.print("Exception :: " + e);
            Print.println();
        }
    }

    public void writeDestinationFile(Destination destination) {
        // TODO: get file lines
        Print.print("Destination File System :: writing file");
        Print.println();

        try {
            PrintWriter printWriter = new PrintWriter(getDestinationFilePath(), "UTF-8");

            printWriter.println("Destination id : " + destination.getDestinationId());
            printWriter.println();
            printWriter.println("Destination name : " + destination.getDestinationName());
            printWriter.println();

            printWriter.println("Printing activity list : ");
            printWriter.println();
            int activityLine = 1;

            List<Activity> activityList = destination.getActivityList();

            for (Activity activity : activityList) {
                printWriter.println("Activity " + activityLine + " : ");
                printWriter.println();
                activityLine++;

                printWriter.println("Activity id : " + activity.getActivityId());
                printWriter.println();
                printWriter.println("Activity name : " + activity.getActivityName());
                printWriter.println();
                printWriter.println("Activity description : " + activity.getActivityDescription());
                printWriter.println();
                printWriter.println("Activity cost : " + activity.getActivityCost());
                printWriter.println();
                printWriter.println("Activity capacity : " + activity.getActivityCapacity());
                printWriter.println();

            }

            Print.println();
            Print.print("Written :: Destination file successfully");
            Print.println();

            printWriter.close();

        } catch (Exception e) {
            Print.print("Exception :: " + e);
            Print.println();
        }
    }

    public void deleteTravelPackageFile() {
        Print.print("Inside delete File");
        Print.println();
        try {

            boolean isFileDeleted = Files.deleteIfExists(Paths.get(getDestinationFilePath()));
            if (isFileDeleted) {
                Print.println();
                Print.print("Deleted :: Destination file successfully!");
                Print.println();
            }

        } catch (Exception e) {
            Print.print("Exception :: " + e);
            Print.println();
        }

    }
}
