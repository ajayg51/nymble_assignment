package com.example.nymble_assignment.classes;

import com.example.nymble_assignment.utils.Print;

public class Activity {
    private int destinationId;

    private int activityId;
    private String activityName;
    private String activityDescription;
    private int activityCost;
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
        Print.println();
        Print.println();
        Print.print("Setting up destination id ::  " + id);
        Print.println();
        Print.println();
        Print.println();
        this.destinationId = id;
    }

    public int getActivityCost() {
        return this.activityCost;
    }

    public void setActivityCost(int cost) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up activity cost  :: " + cost);
        Print.println();
        Print.println();
        Print.println();
        this.activityCost = cost;
    }

    public int getActivityCapacity() {
        return this.activityCapacity;
    }

    public void setActivityCapacity(int capacity) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up activity capacity :: " + capacity);
        Print.println();
        Print.println();
        Print.println();
        this.activityCapacity = capacity;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String name) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up activity name :: " + name);
        Print.println();
        Print.println();
        Print.println();
        this.activityName = name;
    }

    public String getActivityDescription() {
        return this.activityDescription;
    }

    public void setActivityDescription(String description) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up activity description ::  " + description);
        Print.println();
        Print.println();
        Print.println();

        this.activityDescription = description;
    }

    public void onActivitySubscription(
            Activity activity,
            TravelPackage travelPackage) {

        activity.activityCapacity--;

        travelPackage
                .setTravelPackagePassengerCapacity(travelPackage
                        .getTravelPackagePassengerCapacity() - 1);
    }

    public void printDestinatioDetailsUsingTravelObj(TravelPackage travelPackage) {
        travelPackage.filterDestinationById(101);
        Destination destination = travelPackage.getFilteredDestination();
        Print.println();
        Print.println();
        Print.print("Destination name :: " + destination.getDestinationName());
        Print.println();
    }

    public void printActivityDetails(Activity activity) {
        Print.print("Activity name :: " + activity.getActivityName());
        Print.println();
        Print.print("Activity description :: " + activity.getActivityDescription());
        Print.println();
        Print.print("Activity cost :: " + activity.getActivityCapacity());
        Print.println();
        Print.print("Activity capacity :: " + activity.getActivityCapacity());

    }

    public void printActivityDetailsMappedWithTravelPkg(
            TravelPackage travelPackage,
            Activity activity) {

        // try {
        // Print.println();
        // Print.println();
        // Print.println();
        // Print.print("<----------- Activity Info Start Mapped with Travel Pkg ::::
        // --------------->");
        // Print.println();
        // Print.print("Activity id : " + activity.activityId);
        // Print.println();

        // // activity name missing
        // Print.print("Activity name : " + activity.activityName);
        // Print.println();
        // Print.print("Activity capacity : " + activity.activityCapacity);
        // Print.println();
        // Print.print("Activity cost : " + activity.activityCost);
        // Print.println();

        // // activity desc missing

        // Print.print("Activity description : " + activity.activityDescription);
        // Print.println();
        // Print.println();
        // Print.println();
        // Print.println();
        // Print.print("Mapped Destination Details : ");
        // Print.println();

        // if (travelPackage != null) {

        // Destination destination =
        // travelPackage.getDestinationById(activity.destinationId);

        // if (destination != null) {
        // Print.print("Mapped Destination id : " + destination.getDestinationId());
        // Print.println();
        // Print.print("Destination name : " + destination.getDestinationName());
        // Print.println();
        // }

        // } else {

        // Print.print("travelPackage found null in Activity.java");
        // Print.println();
        // }

        // Print.print("<----------- Activity Info End :::: --------------->");
        // Print.println();
        // Print.println();
        // Print.println();

        // } catch (Exception e) {
        // Print.println();
        // Print.println();
        // Print.println();
        // Print.print(e);
        // Print.println();
        // Print.println();
        // Print.println();
        // }

    }

}
