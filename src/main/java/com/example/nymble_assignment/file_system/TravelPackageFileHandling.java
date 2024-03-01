package com.example.nymble_assignment.file_system;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Print;

public class TravelPackageFileHandling {
    private static  String travelPackageFilePath = "travelPackage.txt";


    public static  String getTravelPackagePath() {
        return travelPackageFilePath;
    }

    public static  void readTravelPackageFile() {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Inside Travel Package read File");
        Print.println();
        Print.println();
        Print.println();
        try {
            List<String> allReadLines = Files.readAllLines(Paths.get(getTravelPackagePath()));
            Print.println();
            Print.println();
            Print.print("Read :: Travel Package file successfully");
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

    public static void writeTravelPackageFile(TravelPackage travelPackage) {
        // TODO: get file lines
        Print.print("Travel Package File System :: writing file");
        Print.println();

        try {
            PrintWriter printWriter = new PrintWriter(getTravelPackagePath(), "UTF-8");

            printWriter.println();
            printWriter.print("Travel Package File");
            printWriter.println();
            printWriter.println("Travel Package id : " + travelPackage.getTravelPackageId());
            printWriter.println();
            printWriter.println("Travel Package name : " + travelPackage.getTravelPackageName());
            printWriter.println();
            printWriter.println(
                    "Travel Package passenger capacity : "
                            + travelPackage.getTravelPackagePassengerCapacity());
            printWriter.println();

            writeDestinationDetails(printWriter, travelPackage);

            Print.println();
            Print.print("Written :: Travel package file successfully");
            Print.println();

            printWriter.close();

        } catch (Exception e) {
            Print.print("Exception :: " + e);
            Print.println();
        }
    }

    private static void writeDestinationDetails(PrintWriter printWriter, TravelPackage travelPackage) {
        int destLine = 1;

        printWriter.println();
        printWriter.println("Printing destination list : ");
        printWriter.println();

        for (Destination destination : travelPackage.getDestinationList()) {
            printWriter.println("Destination " + destLine + " : ");
            printWriter.println();
            destLine++;
            printWriter.println("Destination id : " + destination.getDestinationId());
            printWriter.println();
            printWriter.println("Destination name : " + destination.getDestinationName());
            printWriter.println();

            writeActivityDetails(printWriter, destination);

        }

    }

    private static  void writeActivityDetails(
            PrintWriter printWriter,
            Destination destination) {

        int activityLine = 1;
        List<Activity> activityList = destination.getActivityList();

        printWriter.println();
        printWriter.println("Printing activity list : ");
        printWriter.println();

        for (Activity activity : activityList) {
            printWriter.println("Activity : " + activityLine);
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

    }

    public static void deleteTravelPackageFile() {
        Print.print("Inside delete File");
        Print.println();
        try {

            boolean isFileDeleted = Files.deleteIfExists(Paths.get(getTravelPackagePath()));
            if (isFileDeleted) {
                Print.print("Deleted :: Travel package file successfully!");
                Print.println();
            }

        } catch (Exception e) {
            Print.print("Exception :: " + e);
            Print.println();
        }

    }
}
