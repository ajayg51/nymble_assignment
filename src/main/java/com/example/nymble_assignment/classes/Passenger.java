package com.example.nymble_assignment.classes;

import java.util.ArrayList;
import java.util.List;

import com.example.nymble_assignment.utils.PassengerTypeEnum;
import com.example.nymble_assignment.utils.Print;

public class Passenger {
    private int passengerId;
    private int destinationId;
    private String passengerName;
    private int balance;
    private PassengerTypeEnum passengerType;
    private List<Activity> subscribedActivityList;

    public Passenger(int id) {
        this.passengerId = id;
        this.subscribedActivityList = new ArrayList<Activity>();
    }

    public int getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(int id) {
        this.passengerId = id;
    }

    public int getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(int id) {
        this.destinationId = id;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public void setPassengerName(String name) {
        Print.println();
        Print.print("Setting up passenger name :: " + name);
        Print.println();
        Print.println();
        this.passengerName = name;
    }

    public PassengerTypeEnum getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(int choice) {
        switch (choice) {
            case 1:
                this.passengerType = PassengerTypeEnum.standard;
                break;
            case 2:
                this.passengerType = PassengerTypeEnum.gold;
                break;
            case 3:
                this.passengerType = PassengerTypeEnum.premium;
                break;
            default:
                this.passengerType = PassengerTypeEnum.standard;

        }
    }

    public List<Activity> getSubscribedActivityList() {
        return this.subscribedActivityList;
    }

    public void addActivityInList(Activity activity) {
        if (activity != null)
            this.subscribedActivityList.add(activity);
        else
            Print.print("activity found null in Passenger.java");

    }

    public boolean isPassengerAllowedForSubscription(
            PassengerTypeEnum passengerTypeEnum,
            int cost) {
        switch (passengerTypeEnum) {
            case standard:
                return this.balance >= cost;
            case gold:
                return this.balance >= cost;
            case premium:
                return true;

            default:
                return false;
        }
    }

    public void subscribePassenger(
            Passenger passenger,
            Activity activity,
            TravelPackage travelPackage) {
        if (isPassengerAllowedForSubscription(
                this.passengerType,
                activity.getActivityCost())) {
            final int activityCost = activity.getActivityCost();

            switch (this.passengerType) {
                case standard:
                    this.balance -= activityCost;
                    break;
                case gold:
                    this.balance -= activityCost * 0.9;
                    break;

                default:
                    break;
            }

            activity.onActivitySubscription(activity, travelPackage);

            this.subscribedActivityList.add(activity);

            travelPackage.addPassengerInList(passenger);

            Print.println();
            Print.println();
            Print.print("Passenger subscribed for given activity successfully");
            Print.println();
            Print.println();
        }
    }

    public String getPassengerType(PassengerTypeEnum passengerTypeEnum) {
        if (passengerTypeEnum != null) {
            switch (passengerTypeEnum) {
                case standard:
                    return "Standard";
                case gold:
                    return "Gold";
                case premium:
                    return "Premium";

                default:
                    return "";
            }
        }
        return "";
    }

    public void printPassengerDetails(Passenger passenger, TravelPackage travelPackage) {
        try {
            Print.println();
            Print.println();
            Print.println();
            Print.print("<----------- Passenger info Start :::: --------------->");
            Print.println();
            Print.print("Passenger id : " + passenger.passengerId);
            Print.println();

            // passenger name is missing
            Print.print("Passenger name : " + passenger.passengerName);
            Print.println();
            if (passenger.passengerType != PassengerTypeEnum.premium) {

                Print.print("Passenger balance : " + passenger.balance);
                Print.println();
            }

            if (passenger.passengerType != null) {

                Print.print("Passenger type : " + getPassengerType(passenger.passengerType));
                Print.println();
            }

            if (this.subscribedActivityList != null) {
                Print.println();
                Print.println();
                Print.println();
                Print.print("Subscribed activity details");
                Print.println();

                for (Activity activity : this.subscribedActivityList) {
                    activity.printDestinatioDetailsUsingTravelObj(travelPackage);
                    activity.printActivityDetails(activity);
                }

            } else
                Print.print("subscribedActivityList found null in Passenger.java");
            Print.println();
            Print.print("<----------- Passenger info end :::: --------------->");
            Print.println();
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

}
