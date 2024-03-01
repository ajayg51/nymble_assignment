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
    private List<Passenger> subscribedPassengerList;

    public TravelPackage(
            int travelPackageId) {

        this.travelPackageId = travelPackageId;
        this.destinationList = new ArrayList<Destination>();
        this.passengerList = new ArrayList<Passenger>();
        this.subscribedPassengerList = new ArrayList<Passenger>();

    }

    public int getTravelPackageId() {
        return this.travelPackageId;
    }

    public void setTravelPackageId(int id) {
        Print.println();
        Print.print("Setting up travel package id :: " + id);
        this.travelPackageId = id;
        Print.println();
    }

    public int getTravelPackagePassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setTravelPackagePassengerCapacity(int capacity) {
        Print.println();
        Print.print("Setting up travel package capacity : travelPackage.java " + capacity);
        this.passengerCapacity = capacity;
        Print.println();

    }

    public void updateTravelPackagePassengerCapacity(int capacity) {
        Print.println();
        Print.print("Updating passenger capacity :: travel package.java : new capacity :: " + capacity);
        Print.println();
        this.setTravelPackagePassengerCapacity(capacity);
    }

    public String getTravelPackageName() {
        return this.travelPackageName;
    }

    public void setTravelPackageName(String name) {
        Print.println();
        Print.print("Setting up travel package name :: " + name);
        this.travelPackageName = name;
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
        } else {
            // Print.println();
            // Print.print("Found destination for id : " + destinationId);
            // Print.println();
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

    // public void deletePassengerFromPassengerList(
    // Passenger passenger) {
    // if (passenger.getPassengerId() == Constants.errorCode) {
    // Print.println();
    // Print.print("Passenger not found :: Travel package.java ");
    // Print.println();
    // }

    // this.passengerList.remove(passenger);

    // }

    public List<Destination> getDestinationList() {
        return this.destinationList;
    }

    public void addDestinationInList(Destination destination) {
        if (destination.getDestinationId() != Constants.errorCode)
            this.destinationList.add(destination);
        else
            Print.print("destination found null in TravelPackage.java");
    }

    public List<Passenger> getPassengerList() {
        return this.passengerList;
    }

    public boolean addPassengerInList(Passenger passenger) {

        if (this.passengerList.size() < passengerCapacity) {
            if (passenger.getPassengerId() != Constants.errorCode) {

                this.passengerList.add(passenger);

                Print.print("Added passenger in travel package object successfully");
                Print.println();
                Print.print("Passenger id :: TravelPackage file ::: " + passenger.getPassengerId());

                Print.println();
                return true;
            } else {
                Print.println();
                Print.print("passenger found null in TravelPackage.java");
                Print.println();
            }
        } else {
            Print.println();
            Print.println();
            Print.print("No more passengers can be added");
            Print.println();
        }
        return false;

    }

    public List<Passenger> getSubscribedPassengerList() {
        return this.subscribedPassengerList;
    }

    public void addSubscribedPassengerInList(Passenger passenger) {

        if (passenger.getPassengerId() != Constants.errorCode) {

            if (this.getPassengerList()
                    .size() > this
                            .getSubscribedPassengerList()
                            .size()) {
                this.subscribedPassengerList.add(passenger);

                Print.print("Added subsribed passenger successfully : Travel package.java");
                Print.println();
                Print.print("Passenger id : " + passenger.getPassengerId());

                Print.println();

            } else {
                Print.println();
                Print.print("Cannot subscribe any more passenger TravelPackage.java");
                Print.println();
            }

        } else {
            Print.println();
            Print.print("passenger found null in TravelPackage.java");
            Print.println();
        }

    }

    public boolean isPassengerExhausted() {
        return this.passengerList.size() <= this.subscribedPassengerList.size();
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

    public void printTravelPackageDetails() {
        try {
            Print.print("Travel package id : " + this.travelPackageId);
            Print.println();
            Print.print("Travel package name : " + this.travelPackageName);
            Print.println();
            Print.print("Passenger capacity : " + this.passengerCapacity);
            Print.println();
            this.printTravelPkgDestinationDetails();

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

    public void printTravelPkgDestinationDetails() {
        Print.println();
        Print.print("Showing Travel Package Destination info");
        Print.println();
        if (this.destinationList.size() > 0) {
            Print.print("Showing destination list : ");
            Print.println();
            for (Destination item : this.destinationList) {
                item.printDestinationDetails(item, this);

            }
        } else
            Print.print("destinationList found empty in TravelPackage.java");

        Print.println();
        Print.println();
    }

    public void printTravelPkgPassengerDetails() {

        if (this.passengerList.size() > 0) {
            Print.println();
            Print.println();
            Print.println();
            Print.print("Showing Travel Package Passenger info");
            Print.println();
            Print.println();
            Print.println();
            Print.print("Travel package file passenger list size ::  " + this.passengerList.size());
            Print.println();
            Print.println();
            Print.println();
            Print.print("Passenger details :: ");
            Print.println();

            int passengerCount = 1;

            for (Passenger item : this.passengerList) {
                Print.println();
                Print.print("Passenger :: " + passengerCount++);
                Print.println();
                item.printPassengerDetails(item, this);
                Print.println();
            }
        } else
            Print.print("passengerList found empty in TravelPackage.java");
        Print.println();
        Print.println();
    }

}
