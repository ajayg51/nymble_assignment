package com.example.nymble_assignment;

import org.junit.jupiter.api.Test;

import com.example.nymble_assignment.classes.Passenger;
import com.example.nymble_assignment.classes.TravelPackage;
import com.example.nymble_assignment.utils.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TravelPackageTest {

    TravelPackage travelPackage;

    TravelPackageTest() {
        travelPackage = new TravelPackage(Constants.errorCode);
    }

    @Test
    public void testAddPassengerInList() {
        travelPackage.setTravelPackagePassengerCapacity(0);
        Passenger passenger = new Passenger(1);
        travelPackage.addPassengerInList(passenger);

        // TODO: expected 1 actual 0
        assertEquals(1, travelPackage.getPassengerList().size());

    }

}
