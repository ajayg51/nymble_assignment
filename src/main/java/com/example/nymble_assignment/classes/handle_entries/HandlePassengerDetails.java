package com.example.nymble_assignment.classes.handle_entries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.Passenger;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class HandlePassengerDetails {

        private static void enterPassengerType(
                        Scanner scanner,
                        Passenger passenger) {

                // TODO: Enter passenger type

                Print.print("Enter passenger type  :");
                Print.println();
                Print.print("Press 1 for passenger type : standard");
                Print.println();
                Print.print("Press 2 for passenger type : gold");
                Print.println();
                Print.print("Press 3 for passenger type : premium");
                Print.println();
                Print.println();
                Print.print("Only an int input ::  ");

                int choice = scanner.nextInt();

                passenger.setPassengerType(choice);

        }

        public static void enterPassengerDetails(
                        Scanner scanner,
                        TravelPackage travelPackage) {

                Print.println();
                Print.print("Entering passenger details ---->>");
                Print.println();

                int passengerCount = 1;

                do {
                        Passenger passenger = new Passenger(Constants.errorCode);

                        String passengerIdStr = Integer.toString(passengerCount);

                        int passengerId = Integer
                                        .parseInt(
                                                        // destinationIdStr
                                                        // + activityIdStr +
                                                        passengerIdStr);

                        passenger.setPassengerId(passengerId);

                        if (passengerCount > 1) {

                                scanner.nextLine();
                        }

                        Print.println();
                        Print.print("Enter passenger name :");
                        Print.println();
                        Print.print("Only a string input ::  ");

                        String passengerName = scanner.nextLine();
                        passenger.setPassengerName(passengerName);

                        // TODO: debugging
                        // Print.println();
                        // Print.print("passenger name : " + passengerName);
                        // Print.println();

                        enterPassengerType(scanner, passenger);

                        // TODO: Enter balance

                        Print.println();
                        Print.print("Enter balance :");
                        Print.println();
                        Print.print("Only an int input ::  ");

                        int balance = scanner.nextInt();

                        passenger.setBalance(balance);

                        travelPackage.addPassengerInList(passenger);

                        passengerCount++;

                        Print.println();
                        Print.print("Want to add more passengers ");
                        Print.println();
                        Print.print("Press 1 for yes and 0 for no");
                        Print.println();

                        int choice = scanner.nextInt();

                        boolean isFurtherSubscriptionAllowed = travelPackage.getPassengerList()
                                        .size() >= travelPackage.getTravelPackagePassengerCapacity();

                        if (choice == 0 || isFurtherSubscriptionAllowed) {

                                if (isFurtherSubscriptionAllowed) {
                                        Print.println();
                                        Print.println();
                                        Print.print("No more passengers can be added");

                                        Print.println();
                                }else{
                                        Print.println();
                                        Print.println();
                                        Print.print("Exiting");
                                        Print.println();
                                }

                                break;
                        }

                } while (true);

        }

        public static void subscribePassenger(
                        Scanner scanner,
                        TravelPackage travelPackage) {

                do {
                        
                        if (travelPackage.isPassengerExhausted()) {
                                Print.println();
                                Print.println();
                                Print.print("Subscription failure : handlePassengerDetails.java ");
                                Print.println();
                                Print.print("passenger capacity exhausted status :"
                                                + travelPackage.isPassengerExhausted());
                                Print.println();
                                Print.print("Printing travel package passenger list");
                                for (Passenger passenger : travelPackage.getPassengerList()) {
                                        Print.println();

                                        Print.print("Passenger id : " + passenger.getPassengerId());
                                        Print.println();
                                        Print.print("Passenger name : " + passenger.getPassengerName());
                                        Print.println();
                                        Print.print("Passenger subscription status : "
                                                        + passenger.getIsSubscribedToAnActivity());
                                        Print.println();
                                }

                        }

                        int passengerId = Constants.errorCode;

                        // FIXME: used when buffer not empty
                        // scanner.nextLine();

                        for (Passenger passenger : travelPackage.getPassengerList()) {
                                Print.println();
                                Print.println();
                                Print.print("Passenger id :: HandlePassengerDetails File ::: "
                                                + passenger.getPassengerId());
                                Print.println();
                                Print.print("Passenger name :: HandlePassengerDetails File ::: "
                                                + passenger.getPassengerName());
                                Print.println();
                        }

                        Print.println();
                        Print.print("Enter passenger id : ");
                        Print.println();
                        Print.print("An int value : ");

                        passengerId = scanner.nextInt();

                        Passenger passenger = travelPackage
                                        .getPassengerByIdFromPassengerList(passengerId);

                        if (passenger.getPassengerId() != Constants.errorCode) {

                                // TODO: passenger balance before subscription
                                // Print.println();
                                // Print.print("passenger balance before subscription : " + passenger.getBalance());
                                // Print.println();

                                boolean isSubscribed = handleDestinationActivityEntryAndSubsription(
                                                scanner,
                                                travelPackage,
                                                passenger);

                                if (isSubscribed) {
                                        Print.println();
                                        Print.print("Subscription successful :: HandlePassengerDetails.java");
                                        Print.println();

                                        Print.print("Passenger subscription status :: HandlePassengerDetails.java "
                                                        + passenger.getIsSubscribedToAnActivity());

                                        // TODO: passenger balance before subscription
                                        Print.println();
                                        Print.print("passenger balance after subscription : " + passenger.getBalance());
                                        Print.println();
                                        Print.print("HandlePassengerDetails.java");

                                        Print.println();

                                } else {
                                        Print.println();
                                        Print.print("Subscription failure :: try to subscribe again :: HandlePassengerDetails.java");
                                        Print.println();
                                }

                                Print.println();
                                Print.println();
                                Print.print("Want to subscribe more ");
                                Print.println();
                                Print.print("Press 1 for yes and 0 to exit");
                                Print.println();

                                int choice = scanner.nextInt();
                                if (choice == 0) {
                                        break;
                                }
                        }

                } while (true);

                // return passengerList;

        }

        private static boolean handleDestinationActivityEntryAndSubsription(
                        Scanner scanner,
                        TravelPackage travelPackage,
                        Passenger passenger) {

                Destination destination = getDestination(scanner, travelPackage);

                if (destination.getDestinationId() != Constants.errorCode) {

                        Activity activity = getActivity(scanner, destination);

                        if (activity.getActivityId() != Constants.errorCode) {

                                // TODO: debug
                                // Print.println();
                                // Print.print("here 0");
                                // Print.println();

                                for (Activity item : passenger.getSubscribedActivityList()) {
                                        if (item.getActivityId() == activity.getActivityId()) {
                                                Print.println();
                                                Print.println();
                                                Print.print("User already subscribed for this activity");
                                                Print.println();
                                                Print.println();
                                                return false;
                                        }

                                }

                                boolean IsAbleToSubscribe = passenger.isPassengerAllowedForSubscription(
                                                activity,
                                                travelPackage,
                                                passenger.getPassengerType(),
                                                activity.getActivityCost());

                                if (IsAbleToSubscribe) {

                                        boolean isSubscriptionSuccess = activity.onActivitySubscription(
                                                        travelPackage, activity,
                                                        passenger);

                                        if (isSubscriptionSuccess) {
                                                // TODO: passenger balance before subscription
                                                // Print.println();
                                                // Print.print("passenger balance before subscription : "
                                                //                 + passenger.getBalance());
                                                // Print.println();

                                                // TODO: passenger balance before subscription
                                                Print.println();
                                                Print.print("passenger balance after subscription : "
                                                                + passenger.getBalance());
                                                Print.println();
                                                Print.print("HandlePassengerDetails.java");
                                                Print.println();

                                                return true;
                                        } else {
                                                Print.println();
                                                Print.print("Subscription failure :: activity.java");

                                                Print.println();
                                                Print.print("Travel package capacity is full : ");
                                                Print.print(travelPackage
                                                                .getTravelPackagePassengerCapacity() == travelPackage
                                                                                .getSubscribedPassengerList().size());
                                                Print.println();
                                                Print.println();
                                                return false;
                                        }

                                } else {
                                        Print.println();
                                        Print.print("Subscription failure :: activity.java");
                                        Print.println();
                                        Print.print("Either activity cost is too high ");
                                        Print.println();

                                        Print.print("Cost : " + activity.getActivityCost());
                                        Print.printSpace();
                                        Print.print("Balance : " + passenger.getBalance());
                                        Print.println();
                                        Print.print("or activity capacity is 0");
                                        Print.println();
                                        Print.print("Activity cost : " + activity.getActivityCost());
                                        Print.println();
                                        Print.print("or travel package capacity is 0");
                                        Print.println();
                                        Print.print("Travel package capacity is full : ");
                                        Print.print(travelPackage.getTravelPackagePassengerCapacity() == travelPackage
                                                        .getSubscribedPassengerList().size());
                                        Print.println();
                                        Print.println();
                                }

                                return false;

                        }

                }

                return false;

        }

        private static Destination getDestination(
                        Scanner scanner,
                        TravelPackage travelPackage) {

                Destination destination = new Destination(Constants.errorCode);

                do {
                        int destinationId = Constants.errorCode;

                        Print.print("Destination id and name");
                        Print.println();

                        List<Destination> destinationList = travelPackage.getDestinationList();

                        for (Destination item : destinationList) {
                                Print.println();
                                Print.print("Destination id : " + item.getDestinationId());
                                Print.println();
                                Print.print("Destination name : " + item.getDestinationName());
                                Print.println();
                                Print.println();
                        }

                        Print.println();
                        Print.print("Enter destination id : ");
                        Print.println();
                        Print.print("An int value : ");
                        destinationId = scanner.nextInt();

                        destination = travelPackage
                                        .getDestinationByIdFromDestList(destinationId);

                        if (destination.getDestinationId() != Constants.errorCode) {
                                break;
                        }

                } while (true);

                return destination;
        }

        private static Activity getActivity(
                        Scanner scanner,
                        Destination destination) {

                // TODO: Enter activity Id

                Activity activity = new Activity(Constants.errorCode);

                do {
                        List<Activity> activityList = destination.getActivityList();
                        Print.println();
                        Print.print("Printing activity details ::");
                        Print.println();
                        for (Activity item : activityList) {
                                Print.println();
                                Print.print("Activity id : " + item.getActivityId());
                                Print.println();
                                Print.print("Activity name : " + item.getActivityName());
                                Print.println();
                                Print.print("Activity cost : " + item.getActivityCost());
                                Print.println();
                                Print.print("Activity capacity : " + item.getActivityCapacity());
                                Print.println();
                                Print.println();

                        }
                        Print.println();
                        Print.print("Enter activity id : ");
                        Print.println();
                        Print.print("An int value : ");

                        int activityId = scanner.nextInt();

                        activity = destination.getActivityByIdFromActivityList(activityId);

                        if (activity.getActivityId() != Constants.errorCode) {
                                break;
                        }

                } while (true);

                return activity;

        }

        public static void printPassengerIds(TravelPackage travelPackage) {

                List<Passenger> passengerList = travelPackage.getPassengerList();

                Print.println();
                Print.println();
                Print.print("Printing passenger Ids");
                Print.println();

                for (Passenger passenger : passengerList) {
                        Print.println();
                        Print.print("Passenger id : " + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name : " + passenger.getPassengerName());
                        Print.println();

                        // Print.print("Passenger id :: HandlePassengerDetails File ::: " +
                        // passenger.getPassengerId());
                        // Print.println();

                }

        }

        public static void printPassengerDetails(
                        TravelPackage travelPackage) {

                List<Passenger> passengerList = travelPackage.getPassengerList();

                Print.println();
                Print.print("Printing passenger details :: handlePassengerDetails.java :: ");
                Print.println();

                Print.print("Passenger list size :: " + passengerList.size());
                Print.println();

                for (Passenger passenger : passengerList) {

                        Print.print("Passenger id :: HandlePassengerDetails File ::: "
                                        + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name : "
                                        + passenger.getPassengerName());

                        Print.println();
                        Print.print("Passenger balance : "
                                        + passenger
                                                        .getBalance());
                        Print.println();
                        Print.println();

                        List<Activity> activityList = passenger.getSubscribedActivityList();

                        if (activityList.size() > 0) {

                                Print.println();
                                Print.print("Printing subscribed activity list : " + activityList.size());
                                Print.println();

                                printSubscribedActivityList(passenger);

                                Print.println();
                                Print.print("Printing passenger details end HandlePassengerDetails File ::: ");
                                Print.println();
                        }
                }

        }

        private static void printSubscribedActivityList(
                        Passenger passenger) {

                List<Activity> subscribedList = passenger.getSubscribedActivityList();

                int subscriptionCount = 1;

                for (Activity item : subscribedList) {
                        Print.println();
                        Print.print("Subscription : " + subscriptionCount);
                        Print.println();
                        subscriptionCount++;

                        Print.print("Activity id : " + item.getActivityId());
                        Print.println();
                        Print.print("Activity name : "
                                        + item.getActivityName());
                        Print.println();
                        Print.print("Activity description : "
                                        + item.getActivityDescription());
                        Print.println();
                        Print.println();

                }
        }

}
