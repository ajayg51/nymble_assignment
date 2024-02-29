package com.example.nymble_assignment;

import java.util.Scanner;

import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.classes.handle_entries.HandleActivityDetails;
import com.example.nymble_assignment.classes.handle_entries.HandleDestinationDetails;
import com.example.nymble_assignment.classes.handle_entries.HandlePassengerDetails;
import com.example.nymble_assignment.classes.handle_entries.HandleTravelPackageDetails;
import com.example.nymble_assignment.file_system.TravelPackageFileHandling;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

// FIXME:IMPORTANT for every string input
// FIXME: do scanner.nextLine() for clearing buffer
// FIXME: before any new input segment

public class Main {

        private static void showPackageInfo() {
                Print.println();
                Print.println();
                Print.print("Welcome To Nymble Travel Agency :: ");
                Print.println();
                Print.print("<-------------------------------------->");
                Print.println();
                Print.println();
        }

        // TODO: Main function starts here

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                TravelPackage travelPackage

                                = new TravelPackage(Constants.errorCode);

                TravelPackageFileHandling travelPackageFileHandling

                                = new TravelPackageFileHandling();

                // TODO: shows package info
                showPackageInfo();

                // TODO: sets up travel package details
                HandleTravelPackageDetails

                                .setupTravelPackageDetails(travelPackage);

                // TODO: sets up destination details
                HandleDestinationDetails

                                .setupDestinationDetails(travelPackage);

                // TODO: sets up activity details
                HandleActivityDetails
                                .setupActivityDetails(travelPackage);

                // TODO: entering passenger details
                HandlePassengerDetails.enterPassengerDetails(scanner, travelPackage);

                // TODO: shows up destination details
                HandleDestinationDetails.printDestinationDetails(travelPackage);

                // TODO: displays passenger ids
                HandlePassengerDetails.printPassengerIds(travelPackage);

                // TODO: subscribes passenger
                HandlePassengerDetails
                                .subscribePassenger(scanner, travelPackage);

                // TODO: shows up passenger details
                HandlePassengerDetails.printPassengerDetails(travelPackage);

                // TODO: writes up everything in a file
                travelPackageFileHandling
                                .writeTravelPackageFile(travelPackage);

                Print.println();
                Print.println();

                // TODO: displays file data
                travelPackageFileHandling.readTravelPackageFile();

                scanner.close();
        }

}
