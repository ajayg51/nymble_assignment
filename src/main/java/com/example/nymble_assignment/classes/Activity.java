package com.example.nymble_assignment.classes;

import com.example.nymble_assignment.utils.PassengerTypeEnum;
import com.example.nymble_assignment.utils.Print;

public class Activity {
    private int destinationId;

    private int activityId;
    private String activityName;
    private String activityDescription;
    private double activityCost;
    private int activityCapacity;

    public Activity(
            int id) {
        this.activityId = id;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int id) {
        this.activityId = id;
    }

    public int getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(int id) {
        Print.println();
        Print.print("Setting up destination id ::  " + id);
        Print.println();
        this.destinationId = id;
    }

    public double getActivityCost() {
        return this.activityCost;
    }

    public void setActivityCost(double cost) {
        Print.println();
        Print.print("Setting up activity cost  :: " + cost);
        Print.println();

        this.activityCost = cost;
    }

    public int getActivityCapacity() {
        return this.activityCapacity;
    }

    public void setActivityCapacity(int capacity) {

        Print.println();
        Print.print("Setting up activity capacity :: " + capacity);
        Print.println();

        this.activityCapacity = capacity;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String name) {
        Print.println();
        Print.print("Setting up activity name :: " + name);

        Print.println();
        this.activityName = name;
    }

    public String getActivityDescription() {
        return this.activityDescription;
    }

    public void setActivityDescription(String description) {
        Print.println();
        Print.print("Setting up activity description ::  " + description);
        Print.println();

        this.activityDescription = description;
    }

    public boolean onActivitySubscription(
            TravelPackage travelPackage,
            Activity activity,
            Passenger passenger) {

        if (passenger.getPassengerType() == PassengerTypeEnum.premium) {
            Print.println();
            Print.print("Premium member");
            Print.println();

            if (travelPackage
                    .getSubscribedPassengerList().size() >= travelPackage
                            .getTravelPackagePassengerCapacity()) {
                Print.println();
                Print.println();
                Print.print("Package travel capacity is full : activity.java");
                Print.println();
                Print.println();

                return false;

            } else {
                activity.activityCapacity--;

                passenger.addActivityInList(activity);
                passenger.setIsSubscribedToAnActivity(true);

                // travelPackage.addSubscribedPassengerInList(passenger);

                for (Passenger item : travelPackage.getSubscribedPassengerList()) {
                    if (item.getPassengerId() != passenger.getPassengerId()) {

                        travelPackage.addSubscribedPassengerInList(passenger);
                    } else {
                        travelPackage.getSubscribedPassengerList().remove(passenger);
                    }
                }

                Print.println();
                Print.print("Subscription success :: activity.java");
                Print.println();

                return true;
            }

        } else {
            Print.println();
            Print.print("Non-premium member : activity.java");
            Print.println();

            if (travelPackage
                    .getSubscribedPassengerList().size() >= travelPackage
                            .getTravelPackagePassengerCapacity()) {
                Print.println();
                Print.println();
                Print.print("Package travel capacity is full : activity.java");
                Print.println();
                Print.println();

                return false;

            } else {
                activity.activityCapacity--;

                passenger.addActivityInList(activity);
                passenger.setIsSubscribedToAnActivity(true);

                passenger.updateBalance(activityCost);

                for (Passenger item : travelPackage.getSubscribedPassengerList()) {
                    if (item.getPassengerId() != passenger.getPassengerId()) {

                        travelPackage.addSubscribedPassengerInList(passenger);
                    } else {
                        travelPackage.getSubscribedPassengerList().remove(passenger);
                    }
                }

                Print.println();
                Print.print("Subscription success :: activity.java");
                Print.println();
                
                return true;
            }

        }

    }

    public void printDestinatioDetailsUsingTravelObj(
        TravelPackage travelPackage
    ) {
        travelPackage.filterDestinationById(101);
        Destination destination = travelPackage.getFilteredDestination();
        Print.println();
        Print.println();
        Print.print("Destination name :: " + destination.getDestinationName());
        Print.println();
    }

    public void printActivityDetails(Activity activity, TravelPackage travelPackage) {

        Destination destination = travelPackage
                .getDestinationByIdFromDestList(activity.destinationId);

        Print.println();
        Print.println();
        Print.print("Showing activity details :: activity.java");
        Print.println();
        Print.print("Destination id : " + activity.destinationId);
        Print.print("Destination name : " + destination.getDestinationName());
        Print.println();
        Print.print("Activity id :: " + activity.getActivityId());
        Print.println();
        Print.print("Activity name :: " + activity.getActivityName());
        Print.println();
        Print.print("Activity description :: " + activity.getActivityDescription());
        Print.println();
        Print.print("Activity cost :: " + activity.getActivityCapacity());
        Print.println();
        Print.print("Activity capacity :: " + activity.getActivityCapacity());
        Print.println();

    }


}
