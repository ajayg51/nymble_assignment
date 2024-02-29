package com.example.nymble_assignment.classes.handle_entries;

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

                // TODO: Enter passenger name

                Passenger passenger = new Passenger(Constants.errorCode);

                Print.println();
                Print.println();
                Print.print("Entering passenger details ---->>");
                Print.println();
                Print.println();

                // scanner.nextLine();
                Print.println();
                Print.print("Enter passenger name :");
                Print.println();
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
                Print.println();
                Print.print("Enter balance :");
                Print.println();
                Print.println();
                Print.print("Only an int input ::  ");

                int balance = scanner.nextInt();

                passenger.setBalance(balance);

                travelPackage.addPassengerInList(passenger);

        }

        public static void subscribePassenger(
                        Scanner scanner,
                        TravelPackage travelPackage) {

                if (travelPackage.isPassengerExhausted()) {
                        Print.println();
                        Print.print("Travel package passenger capacity exhausted");
                        Print.println();
                        return;
                }

                int subscriptionPassengerId = Constants.errorCode;

                // FIXME: used when buffer not empty
                // scanner.nextLine();

                Print.println();
                Print.print("Enter passenger id : ");
                Print.println();
                Print.print("An int value : ");

                subscriptionPassengerId = scanner.nextInt();

                Passenger subscriptionPassenger = travelPackage
                                .getPassengerByIdFromPassengerList(subscriptionPassengerId);

                if (subscriptionPassenger.getPassengerId() != Constants.errorCode) {

                        Destination destination = getDestination(scanner, travelPackage);

                        if (destination.getDestinationId() != Constants.errorCode) {

                                Activity activity = getActivity(scanner, destination);

                                if (activity.getActivityId() != Constants.errorCode) {

                                        activity.onActivitySubscription(
                                                        activity, travelPackage);

                                        subscriptionPassenger
                                                        .subscribePassenger(
                                                                        subscriptionPassenger,
                                                                        activity, travelPackage);

                                        Print.println();
                                        Print.println();
                                        Print.print("Printing passenger details");
                                        Print.println();
                                        Print.println();

                                        // printPassengerDetails(subscriptionPassenger);
                                }
                        }
                }

        }

        private static Destination getDestination(
                        Scanner scanner,
                        TravelPackage travelPackage) {

                // TODO: Enter destination Id

                Print.println();
                Print.print("Enter destination id : ");
                Print.println();
                Print.print("An int value : ");
                int destinationId = scanner.nextInt();

                return travelPackage
                                .getDestinationByIdFromDestList(destinationId);

        }

        private static Activity getActivity(
                        Scanner scanner,
                        Destination destination) {

                int activityId = Constants.errorCode;

                // TODO: Enter activity Id

                Print.println();
                Print.print("Enter activity id : ");
                Print.println();
                Print.print("An int value : ");
                activityId = scanner.nextInt();

                return destination
                                .getActivityByIdFromActivityList(activityId);

        }

        public static void printPassengerIds(TravelPackage travelPackage) {

                List<Passenger> passengerList = travelPackage.getPassengerList();

                Print.println();
                Print.println();
                Print.print("Printing passenger Ids");
                Print.println();
                Print.println();

                int passengerCount = 1;
                for (Passenger passenger : passengerList) {
                        Print.print("Passenger : " + passengerCount);
                        Print.println();
                        passengerCount++;

                        Print.print("Passenger id : " + passenger.getPassengerId());
                        Print.println();
                }

        }

        public static void printPassengerDetails(
                        TravelPackage travelPackage) {

                List<Passenger> passengerList = travelPackage.getPassengerList();

                int passengerCount = 1;

                Print.println();
                Print.print("Printing passenger details after subscription");
                Print.println();

                for (Passenger passenger : passengerList) {

                        Print.print("Passenger id : "
                                        + passenger.getPassengerId());
                        Print.println();
                        Print.print("Passenger name : "
                                        + passenger.getPassengerName());
                        Print.println();
                        Print.print("Passenger name : "
                                        + passenger.getPassengerName());
                        Print.println();
                        Print.print("Passenger balance : "
                                        + passenger
                                                        .getBalance());

                        Print.println();
                        Print.println();
                        Print.print("Printing subscribed activity list : ");
                        Print.println();
                        Print.println();
                        printSubscribedActivityList(passenger);
                }

        }

        private static void printSubscribedActivityList(
                        Passenger passenger) {

                List<Activity> subscribedList = passenger.getSubscribedActivityList();

                int subscriptionCount = 1;

                for (Activity item : subscribedList) {
                        Print.println();
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

                }
        }

}
