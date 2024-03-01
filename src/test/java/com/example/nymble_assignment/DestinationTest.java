package com.example.nymble_assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.nymble_assignment.classes.Activity;
import com.example.nymble_assignment.classes.Destination;
import com.example.nymble_assignment.utils.Constants;

public class DestinationTest {

    @Test
    public void testAddActivityInListInDestination() {
        Destination destination = new Destination(0);

        Activity activity = new Activity(0);

        destination.addActivityInList(activity);

        // TODO: expected 404 actual 1
        assertEquals(Constants.errorCode, destination.getActivityList().size());
    }
}
