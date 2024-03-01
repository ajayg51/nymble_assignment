package com.example.nymble_assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Passenger;
import com.example.nymble_assignment.classes.TravelPackage;

public class ActivityTest {
 
    @Test
    public void testActivitySubscription(){
        TravelPackage travelPackage = new TravelPackage(0);
        
        travelPackage.setTravelPackagePassengerCapacity(0);

        Passenger passenger = new Passenger(0);
        passenger.setPassengerType(3);
       
        travelPackage.addSubscribedPassengerInList(passenger);

        // TODO: expected 1 actual 0
        assertEquals( 1,travelPackage.getSubscribedPassengerList().size());
        
        
    }
}
