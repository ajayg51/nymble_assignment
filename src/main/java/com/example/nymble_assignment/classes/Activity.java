package com.example.nymble_assignment.classes;

import com.example.nymble_assignment.utils.Print;

public class Activity {
    int activityId;
    int destinationId;
    int activityCost;
    int activityCapacity;
    String activityName;
    String activityDescription;

    public Activity(
            int id,
            int destinationId,
            int cost,
            int capacity,
            String name,
            String activityDescription) {
        this.activityId = id;
        this.activityName = name;
        this.activityCapacity = capacity;
        this.activityCost = cost;
        this.activityDescription = activityDescription;
        this.destinationId = destinationId;
    }

    public void onActivitySubscription(
        Activity activity
    ){
        activity.activityCapacity --;
    }

    public void printActivityDetails(
            Object travelObject,
            Activity activity) {

        Print.print("<----------- Activity Info Start :::: --------------->");
        Print.print("Activity id : " + activity.activityId);
        Print.println();
        Print.print("Activity name : " + activity.activityName);
        Print.println();
        Print.print("Activity capacity : " + activity.activityCapacity);
        Print.println();
        Print.print("Activity cost : " + activity.activityCost);
        Print.println();
        Print.print("Activity description : " + activity.activityDescription);
        Print.println();
        Print.print("Mapped Destination Details : ");
        Print.println();

        if (travelObject != null) {
            TravelPackage travelPkg = (TravelPackage) travelObject;
            Object destinationObject = travelPkg.getDestinationById(activity.destinationId);
            if (destinationObject != null) {
                Print.print("Mapped Destination id : " + activity.destinationId);
                Print.println();
                Destination destination = (Destination) destinationObject;
                Print.print("Destination name : " + destination.destinationName);
                Print.println();
            }
        }

        Print.print("<----------- Activity Info End :::: --------------->");

    }

}
