package com.example.nymble_assignment.classes.handle_entries;

import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

public class HandleTravelPackageDetails {

    public static void setupTravelPackageDetails(
            TravelPackage travelPackage) {

        Print.println();
        Print.println();
        Print.print("Setting up Travel package details ---->>");
        Print.println();
        Print.println();

        travelPackage.setTravelPackageId(Constants.travelPackageId);
        travelPackage.setTravelPackageName(Constants.travelPackageName);
        travelPackage.setTravelPackagePassengerCapacity(Constants.travelPackageCapacity);

    }
}
