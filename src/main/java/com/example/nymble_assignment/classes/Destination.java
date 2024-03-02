package com.example.nymble_assignment.classes;

import java.util.ArrayList;
import java.util.List;

import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class Destination {
    private int destinationId;
    private String destinationName;
    private List<Activity> activityList;

    public Destination(
            int id) {
        this.destinationId = id;
        this.activityList = new ArrayList<Activity>();
    }

    public int getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(int id) {
        Print.println();
        Print.print("Setting up destination id :: " + id);
        Print.println();
        this.destinationId = id;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public void setDestinationName(String name) {
        Print.println();
        Print.print("Setting up destination name :: " + name);
        Print.println();
        this.destinationName = name;
    }

    public List<Activity> getActivityList() {
        return this.activityList;
    }

    public Activity getActivityByIdFromActivityList(int activityId) {
        boolean isFound = false;
        Activity activity = new Activity(Constants.errorCode);

        for (Activity item : this.activityList) {
            if (item.getActivityId() == activityId) {
                isFound = true;
                activity = item;
            }
        }
        if (!isFound) {
            Print.println();
            Print.print("Activity not found for id : " + activityId);
            Print.println();
        }

        return activity;

    }

    public void addActivityInList(Activity activity) {
        if (activity.getActivityId() != Constants.errorCode) {
            Print.println();
            Print.println();
            Print.print("Adding activity in destination :: destination.java :: ---> ");
            this.activityList.add(activity);
            Print.println();
        } else
            Print.print("activity found null in Destination.java");
    }

    public void printDestinationDetails(
            Destination destination,
            TravelPackage travelPackage) {

        try {
            Print.println();
            Print.println();
            Print.print("<----------- Destination Info Start :::: --------------->");
            Print.println();
            Print.print("Destination id : " + destination.destinationId);
            Print.println();
            Print.print("Destination name : " + destination.destinationName);
            Print.println();
            if (destination.activityList.size() > 0) {
                Print.print("Showing destination activity list : ");
                Print.println();
                Print.println();
                Print.print("<----------- Activity Info Start in Destination.java :::: --------------->");
                Print.println();

                for (Activity item : destination.activityList) {
                    // item.printDestinatioDetailsUsingTravelObj(travelPackage);
                    item.printActivityDetails(item, travelPackage);
                }
                Print.println();
            } else {

                Print.print("activityList found empty in Destination.java");
                Print.println();
            }

            Print.print("<----------- Destination Info End :::: --------------->");
            Print.println();
            Print.println();

        } catch (Exception e) {
            Print.println();
            Print.println();
            Print.print(e);
            Print.println();
            Print.println();
        }

    }
}
