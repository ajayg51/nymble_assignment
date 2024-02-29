package com.example.nymble_assignment.classes.handle_entries;

import java.util.List;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.file_system.DestinationFileHandling;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class HandleDestinationDetails {

    public static void setupDestinationDetails(
            TravelPackage travelPackage) {

        DestinationFileHandling DestinationFileHandling = new DestinationFileHandling();

        Print.println();
        Print.println();
        Print.print("Setting up destination details");
        Print.println();
        Print.println();

        int destinationCount = 0;
        while (destinationCount < 3) {

            Destination destination = new Destination(Constants.errorCode);

            switch (destinationCount) {
                case 0:
                    Print.println();
                    Print.print("Destination :: " + (destinationCount + 1));
                    destination.setDestinationId(Constants.destination0Id);
                    destination.setDestinationName(Constants.destination0Name);

                    break;

                case 1:
                    Print.println();
                    Print.print("Destination :: " + (destinationCount + 1));
                    destination.setDestinationId(Constants.destination1Id);
                    destination.setDestinationName(Constants.destination1Name);

                    break;

                case 2:
                    Print.println();
                    Print.print("Destination :: " + (destinationCount + 1));
                    destination.setDestinationId(Constants.destination2Id);
                    destination.setDestinationName(Constants.destination2Name);

                    break;

                default:
                    break;
            }

            destinationCount++;

            travelPackage.addDestinationInList(destination);

            DestinationFileHandling.writeDestinationFile(destination);

        }

    }

    public static void printDestinationDetails(TravelPackage travelPackage) {
        List<Destination> destinationList = travelPackage.getDestinationList();

        Print.println();
        Print.print("Printing destination details");
        Print.println();

        int destinationCount = 1;
        int activityCount = 1;

        for (Destination destination : destinationList) {
            Print.println();
            Print.print("Destination : " + destinationCount);
            destinationCount++;

            Print.println();
            Print.print("Destination id : " + destination.getDestinationId());
            Print.println();
            Print.print("Destination name : " + destination.getDestinationName());
            Print.println();
            Print.print("Printing activity details");
            Print.println();

            for (Activity activity : destination.getActivityList()) {
                Print.print("Activity : " + activityCount);
                activityCount++;
                Print.println();
                Print.print("Activity id : " + activity.getActivityId());
                Print.println();
                Print.print("Activity name : " + activity.getActivityName());
                Print.println();
                Print.print("Activity description : " + activity.getActivityDescription());
                Print.println();
                Print.print("Activity cost : " + activity.getActivityCost());
                Print.println();
                Print.print("Activity capacity : " + activity.getActivityCapacity());
                Print.println();

            }

        }
    }
}
