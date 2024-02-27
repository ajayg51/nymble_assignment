package com.example.nymble_assignment.classes;

import java.util.List;

import com.example.nymble_assignment.utils.Print;

public class Destination {
    int destinationId;
    String destinationName;
    List<Activity> activityList;

    public Destination(
        int id, 
        String name,
        List<Activity> list
    ) {
            this.destinationId = id;
            this.destinationName = name;
            this.activityList.addAll(list);
    }

    public void printDestinationDetails(Destination destination) {
        Print.print("<----------- Destination Info Start :::: --------------->");
        Print.print("Destination id : " + destination.destinationId);
        Print.println();
        Print.print("Destination name : " + destination.destinationName);
        Print.println();
        Print.print("destination list : ");
        for(Activity item : destination.activityList){
            item.printActivityDetails(null,item);
        }
        Print.println();
        Print.print("<----------- Destination Info End :::: --------------->");
        
    }
}
