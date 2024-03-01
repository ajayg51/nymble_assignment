package com.example.nymble_assignment.classes.handle_entries;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class HandleActivityDetails {

    public static void setupActivityDetails(
            int activityCount,
            Destination destination,
            TravelPackage travelPackage) {

        // TODO: Add multiple activities in every destination

        Print.println();
        Print.println();
        Print.print("Setting up activity details ---->>");
        Print.println();

        // TODO: add activities in specific destination

        Activity activity = new Activity(Constants.errorCode);

        switch (activityCount) {
            case 1:
                Print.println();
                Print.print("Activity :: " + activityCount );
                Print.println();
                activity.setDestinationId(destination.getDestinationId());
                activity.setActivityId(Constants.activity0Id);
                activity.setActivityName(Constants.activity0Name);
                activity.setActivityDescription(Constants.activity0Description);
                activity.setActivityCost(Constants.activity0Cost);
                activity.setActivityCapacity(Constants.activity0Capacity);

                break;

            case 2:
                Print.println();
                Print.print("Activity :: " + activityCount);
                Print.println();
                activity.setDestinationId(destination.getDestinationId());
                activity.setActivityId(Constants.activity1Id);
                activity.setActivityName(Constants.activity1Name);
                activity.setActivityDescription(Constants.activity1Description);
                activity.setActivityCost(Constants.activity1Cost);
                activity.setActivityCapacity(Constants.activity1Capacity);

                break;

            case 3:
                Print.println();
                Print.print("Activity :: " + activityCount );
                Print.println();
                activity.setDestinationId(destination.getDestinationId());
                activity.setActivityId(Constants.activity2Id);
                activity.setActivityName(Constants.activity2Name);
                activity.setActivityDescription(Constants.activity2Description);
                activity.setActivityCost(Constants.activity2Cost);
                activity.setActivityCapacity(Constants.activity2Capacity);

                break;

            default:
                break;
        }

        destination.addActivityInList(activity);

    }
}
