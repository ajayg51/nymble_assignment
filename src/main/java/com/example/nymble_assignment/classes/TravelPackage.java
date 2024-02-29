package com.example.nymble_assignment.classes;

import java.util.ArrayList;
import java.util.List;

import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.Print;

// Abhi ke liye all classes are public
// baad me abstraction dalenge

public class TravelPackage {
    private int travelPackageId;
    private String travelPackageName;
    private int passengerCapacity;
    private Destination filteredDestination;
    private List<Destination> destinationList;
    private List<Passenger> passengerList;

    public TravelPackage(
            int travelPackageId) {

        this.travelPackageId = travelPackageId;
        this.destinationList = new ArrayList<Destination>();
        this.passengerList = new ArrayList<Passenger>();

    }

    public int getTravelPackageId() {
        return this.travelPackageId;
    }

    public void setTravelPackageId(int id) {
        this.travelPackageId = id;
    }

    public int getTravelPackagePassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setTravelPackagePassengerCapacity(int capacity) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up passenger capacity :: " + capacity);
        this.passengerCapacity = capacity;
        Print.println();
        Print.println();
        Print.println();
    }

    public String getTravelPackageName() {
        return this.travelPackageName;
    }

    public void setTravelPackageName(String name) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Setting up travel package name :: " + name);
        this.travelPackageName = name;
        Print.println();
        Print.println();
        Print.println();
    }

    public Destination getDestinationByIdFromDestList(
            int destinationId) {

        boolean isFound = false;
        Destination destination = new Destination(Constants.errorCode);

        for (Destination dest : this.destinationList) {
            if (dest.getDestinationId() == destinationId) {
                isFound = true;
                destination = dest;
            }
        }
        if (!isFound) {
            Print.println();
            Print.print("Destination not found for id : " + destinationId);
            Print.println();
        }
        return destination;

    }

    public Passenger getPassengerByIdFromPassengerList(
            int passengerId) {
        boolean isFound = false;
        Passenger passenger = new Passenger(Constants.errorCode);

        for (Passenger item : this.passengerList) {
            if (item.getPassengerId() == passengerId) {
                isFound = true;
                passenger = item;
            }
        }
        if (!isFound) {
            Print.println();
            Print.print("Passenger not found for id : " + passengerId);
            Print.println();
        }

        return passenger;

    }

    public List<Destination> getDestinationList() {
        return this.destinationList;
    }

    public void addDestinationInList(Destination destination) {
        if (destination != null)
            this.destinationList.add(destination);
        else
            Print.print("destination found null in TravelPackage.java");
    }

    public List<Passenger> getPassengerList() {
        return this.passengerList;
    }

    public void addPassengerInList(Passenger passenger) {
        if (passenger != null) {
            this.passengerList.add(passenger);
            Print.println();
            Print.println();
            Print.print("Added passenger in travel package object successfully");
            Print.println();
            Print.println();
        } else
            Print.print("passenger found null in TravelPackage.java");
    }

    public boolean isPassengerExhausted() {
        return this.passengerCapacity <= 0;
    }

    public Destination getFilteredDestination() {
        return this.filteredDestination;
    }

    private void setFilteredDestination(Destination destination) {
        this.filteredDestination = destination;
    }

    public void filterDestinationById(int destinationId) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Filtering destination by Id in Travel Package");
        Print.println();
        Print.println();
        Print.println();
        for (Destination item : destinationList) {
            Print.print(item.getDestinationId());
            Print.println();
            if (item.getDestinationId() == destinationId) {
                setFilteredDestination(item);
            }

        }
    }

    public void printTravelPackageDetails(TravelPackage travelPackage) {
        try {
            Print.print("Travel package id : " + travelPackage.travelPackageId);
            Print.println();
            Print.print("Travel package name : " + travelPackage.travelPackageName);
            Print.println();
            Print.print("Passenger capacity : " + travelPackage.passengerCapacity);
            Print.println();
            Print.println();

        } catch (Exception e) {
            Print.println();
            Print.println();
            Print.println();
            Print.print(e);
            Print.println();
            Print.println();
            Print.println();
        }

    }

    public void printTravelPkgDestinationDetails(TravelPackage travelPackage) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Showing Travel Package Destination info");
        Print.println();
        if (travelPackage.destinationList != null) {
            Print.print("Showing destination list : ");
            Print.println();
            for (Destination item : travelPackage.destinationList) {
                item.printDestinationDetails(item, travelPackage);
            }
        } else
            Print.print("destinationList found null in TravelPackage.java");

        Print.println();
        Print.println();
    }

    public void printTravelPkgPassengerDetails(TravelPackage travelPackage) {
        Print.println();
        Print.println();
        Print.println();
        Print.print("Showing Travel Package Passenger info");
        Print.println();

        if (travelPackage.passengerList != null) {
            Print.print("Passenger count : " + travelPackage.passengerList.size());
            Print.println();
            Print.println();
            Print.println();
            Print.print("Passener details :: ");
            Print.println();
            for (Passenger item : travelPackage.passengerList) {
                item.printPassengerDetails(item, travelPackage);
            }
        } else
            Print.print("passengerList found null in TravelPackage.java");
        Print.println();
        Print.println();
    }

}
