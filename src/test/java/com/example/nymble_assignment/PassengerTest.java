package com.example.nymble_assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Passenger;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.PassengerTypeEnum;

public class PassengerTest {
    @Test
    public void testIsPassengerAllowedToSubscribe(){
        TravelPackage travelPackage = new TravelPackage(0);
        Activity activity = new Activity(0);
        Passenger passenger = new Passenger(0);

        passenger.setPassengerType(0);
        passenger.setBalance(0);

        int travelPackagePassengerSize = travelPackage.getPassengerList().size();
        int travelPackageSubscribedListSize = travelPackage.getSubscribedPassengerList().size();

        activity.setActivityCost(100);
        double cost = activity.getActivityCost();
       
        activity.setActivityCapacity(100);
        int activityCapacity = activity.getActivityCapacity();
        

        if(passenger.getPassengerType() == PassengerTypeEnum.standard){
            boolean result = travelPackagePassengerSize > travelPackageSubscribedListSize &&
            activityCapacity > 0 &&
            passenger.getBalance() >= cost;

            // expected true actual false
            assertEquals(true,result);

        }

    }
}
