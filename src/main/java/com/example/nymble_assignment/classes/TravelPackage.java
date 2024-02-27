package com.example.nymble_assignment.classes;

import java.util.List;

import com.example.nymble_assignment.utils.Print;

// Abhi ke liye all classes are public
// baad me abstraction dalenge

public class TravelPackage {
    int travelPackageId;
    String travelPackageName;
    int passengerCapacity;
    List<Destination> destinationList;
    List<Passenger> passengerList;

    public TravelPackage(
            int travelPackageId,
            String travelPackageName,
            int passengerCapacity,
            List<Destination> destinationList,
            List<Passenger> passengerList) {

        this.travelPackageId = travelPackageId;
        this.travelPackageName = travelPackageName;
        this.passengerCapacity = passengerCapacity;
        this.destinationList.addAll(destinationList);
        this.passengerList.addAll(passengerList);

    }

    public Object getDestinationById(int destinationId) {
        for (Destination item : destinationList) {
            if (item.destinationId == destinationId) {
                return item;
            }

        }
        return null;
    }

    static public void printTravelPackageDetails(TravelPackage travelPackage) {
        Print.print("<----------- Travel Package Info Start :::: --------------->");
        Print.print("Travel package id : " + travelPackage.travelPackageId);
        Print.println();
        Print.print("Travel package name : " + travelPackage.travelPackageName);
        Print.println();
        Print.print("Passenger capacity : " + travelPackage.passengerCapacity);
        Print.println();
        Print.print("Passenger count : " + travelPackage.passengerList.size());
        Print.println();
        Print.print("Passenger list : ");
        for (Passenger item : travelPackage.passengerList) {
            item.printPassengerDetails(item);
        }
        Print.print("Destination list : ");
        for (Destination item : travelPackage.destinationList) {
            item.printDestinationDetails(item);
        }
        
        Print.println();
        Print.print("<----------- Travel Package End :::: --------------->");

    }

}
