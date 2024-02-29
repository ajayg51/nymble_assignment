package com.example.nymble_assignment.classes.handle_entries;

import java.util.List;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class HandleActivityDetails {

    public static void setupActivityDetails(
            TravelPackage travelPackage) {

        Print.println();
        Print.println();
        Print.print("Setting up activity details ---->>");
        Print.println();
        Print.println();

        int activityCount = 0;

        List<Destination> destinationList = travelPackage.getDestinationList();

        for (Destination destination : destinationList) {

            while (activityCount < 3) {

                Activity activity = new Activity(Constants.errorCode);

                switch (activityCount) {
                    case 0:
                        Print.println();
                        Print.print("Activity :: " + (activityCount + 1));
                        activity.setActivityId(Constants.activity0Id);
                        activity.setActivityName(Constants.activity0Name);
                        activity.setActivityDescription(Constants.activity0Description);
                        activity.setActivityCost(Constants.activity0Cost);
                        activity.setActivityCapacity(Constants.activity0Capacity);

                        break;

                    case 1:
                        Print.println();
                        Print.print("Activity :: " + (activityCount + 1));
                        activity.setActivityId(Constants.activity1Id);
                        activity.setActivityName(Constants.activity1Name);
                        activity.setActivityDescription(Constants.activity1Description);
                        activity.setActivityCost(Constants.activity1Cost);
                        activity.setActivityCapacity(Constants.activity1Capacity);

                        break;

                    case 2:
                        Print.println();
                        Print.print("Activity :: " + (activityCount + 1));
                        activity.setActivityId(Constants.activity2Id);
                        activity.setActivityName(Constants.activity2Name);
                        activity.setActivityDescription(Constants.activity2Description);
                        activity.setActivityCost(Constants.activity2Cost);
                        activity.setActivityCapacity(Constants.activity2Capacity);

                        break;

                    default:
                        break;
                }

                activityCount++;

                destination.addActivityInList(activity);

            }

        }

    }
}
