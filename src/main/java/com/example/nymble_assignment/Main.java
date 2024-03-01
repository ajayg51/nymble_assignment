package com.example.nymble_assignment;

import java.util.List;
import java.util.Scanner;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.Passenger;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.classes.handle_entries.HandleActivityDetails;
import com.example.nymble_assignment.classes.handle_entries.HandleDestinationDetails;
import com.example.nymble_assignment.classes.handle_entries.HandlePassengerDetails;
import com.example.nymble_assignment.classes.handle_entries.HandleTravelPackageDetails;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.PassengerTypeEnum;
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

                // TODO: shows package info
                showPackageInfo();

                // TODO: sets up travel package details
                HandleTravelPackageDetails
                                .setupTravelPackageDetails(travelPackage);

                // TODO: sets up destination details
                List<Destination> destinationList = HandleDestinationDetails
                                .setupDestinationDetails(travelPackage);

                // TODO: sets up activity details

                int activityCount = 1;
                for (Destination destination : destinationList) {
                        HandleActivityDetails
                                        .setupActivityDetails(
                                                        activityCount,
                                                        destination,
                                                        travelPackage);
                        activityCount++;
                }

                // TODO: debug start

                // TODO: Printing destination info

                // Print.println();
                // Print.println();
                // Print.print("Showing destination : activity details");
                // for (Destination destination : destinationList) {
                // destination.printDestinationDetails(destination, travelPackage);
                // }
                // Print.println();

                // TODO: debug start

                // TODO: adding everything in Travel Package

                for (Destination destination : destinationList) {
                        travelPackage.addDestinationInList(destination);
                }

                // TODO: Printing destination details after adding destination
                // TODO: and activity details

                // Print.println();
                // Print.println();
                // Print.print("Showing destination : activity details ");
                // Print.print("after adding everything in travelPackage");
                // Print.println();

                // travelPackage.printTravelPackageDetails();

                // TODO: entering passenger details

                HandlePassengerDetails
                                .enterPassengerDetails(
                                                scanner,
                                                travelPackage);

                // TODO: Printing passenger details

                // Print.println();
                // Print.print("Printing passenger details : Main.java");
                // Print.println();

                // for (Passenger passenger : passengerList) {

                //         travelPackage.addPassengerInList(passenger);

                // }

                Print.println();

                Print.println();
                Print.print("Printing passenger details :: ");
                travelPackage.printTravelPkgPassengerDetails();

                Print.println();

                Print.println();
                Print.println();
                Print.print("Let's subscribe passenger :: ");
                Print.println();
                Print.println();

                // TODO: displays passenger ids

                HandlePassengerDetails.printPassengerIds(travelPackage);

                // // TODO: subscribes passenger

                HandlePassengerDetails
                                .subscribePassenger(scanner, travelPackage);

                Print.println();
                Print.print("Printing subscribed passengers :: main.java");
                Print.println();

                // TODO: shows up passenger details after
                // TODO: subscription

                for (Passenger passenger : travelPackage.getSubscribedPassengerList()) {

                        Print.println();
                        Print.print("Passenger id : " + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name : " + passenger.getPassengerName());
                        Print.println();
                        Print.println();
                        Print.print("Subscribed activity list : ");

                        List<Activity> activityList = passenger.getSubscribedActivityList();

                        for (Activity activity : activityList) {
                                int destinationId = activity.getDestinationId();
                                Destination destination = travelPackage
                                                .getDestinationByIdFromDestList(destinationId);
                                Print.println();
                                Print.println();
                                Print.print("Destination id : " + destinationId);
                                Print.println();
                                Print.print("Destination name : " + destination.getDestinationName());
                                Print.println();
                                Print.print("Activity id : " + activity.getActivityId());
                                Print.println();
                                Print.print("Activity name : " + activity.getActivityName());
                                Print.println();
                                Print.println();
                                Print.println();

                        }

                        Print.println();
                        Print.print("<----------------------->");
                        Print.println();

                }

                // TODO: Printing Passenger details travel package

                Print.println();
                Print.println();
                Print.print("Printing passenger details : Travel package : Main.java");
                Print.println();
                Print.print("Travel package name : " + travelPackage.getTravelPackageName());
                Print.println();
                Print.print("Passenger capacity  : " + travelPackage.getTravelPackagePassengerCapacity());
                Print.println();
                Print.print("Passengers enrolled count  : " + travelPackage.getPassengerList().size());
                Print.println();
                Print.println();

                for (Passenger passenger : travelPackage.getPassengerList()) {
                        Print.print("Passenger id  : " + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name  : " + passenger.getPassengerName());
                        Print.println();
                }

                // TODO: Printing Passenger details

                Print.println();
                Print.println();
                Print.println();
                for (Passenger passenger : travelPackage.getSubscribedPassengerList()) {
                        Print.print("Passenger id  : " + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name  : " + passenger.getPassengerName());
                        Print.println();
                        PassengerTypeEnum passengerType = passenger.getPassengerType();
                        Print.print("Passenger type  : " + passengerType);
                        Print.println();
                        if (passengerType != PassengerTypeEnum.premium) {
                                Print.print("Passenger balance  : " + passenger.getBalance());
                                Print.println();
                        }
                        Print.print("Printing subscribed activity list : ");
                        Print.println();
                        for (Activity activity : passenger.getSubscribedActivityList()) {
                                Destination destination = travelPackage
                                                .getDestinationByIdFromDestList(activity.getDestinationId());
                                Print.print("Destination : " + destination.getDestinationName());
                                Print.println();
                                Print.print("Activity : " + activity.getActivityName());
                                Print.println();
                                Print.print("Price paid for above activity");
                                Print.println();
                                switch (passengerType) {
                                        case standard:
                                                Print.print(activity.getActivityCost());
                                                
                                                break;
                                        case gold:
                                                Print.print(activity.getActivityCost() * 0.9);
                                                break;

                                        default:
                                                Print.print(0);
                                }
                                Print.println();
                                Print.println();
                                Print.println();
                                
                        }
                }

                // TODO: Printing Activity details

                for(Destination destination : travelPackage.getDestinationList()){
                        for(Activity activity : destination.getActivityList()){
                                if(activity.getActivityCapacity() > 0){
                                        Print.println();
                                        Print.println();
                                        Print.print("Activity name : "+activity.getActivityName());
                                        Print.println();
                                        Print.print("Activity capacity : "+activity.getActivityCapacity());
                                        Print.println();
                                        Print.println();
                                }
                        }
                }


                // TODO: Writing to file block

                // Print.println();
                // Print.println();
                // Print.print("Writing to file system");
                // Print.println();
                // Print.println();

                // // TODO: writes up everything in a file

                // // TODO: writing everything to destination file
                // DestinationFileHandling.writeDestinationFile(destinationList);

                // TravelPackageFileHandling
                // .writeTravelPackageFile(travelPackage);

                // Print.println();
                // Print.println();
                // Print.print("Reading from file system");
                // Print.println();
                // Print.println();

                // // TODO: displays file data

                // TravelPackageFileHandling.readTravelPackageFile();

                scanner.close();
        }

}
