package com.example.nymble_assignment.classes;

import java.util.List;

import com.example.nymble_assignment.utils.PassengerTypeEnum;
import com.example.nymble_assignment.utils.Print;

public class Passenger {
    int passengerId;
    String passengerName;
    int balance;
    PassengerTypeEnum passengerTypeEnum;
    List<Activity> subscribedActivityList;

    public Passenger(
            int id,
            String name,
            int balance,
            PassengerTypeEnum passengerTypeEnum) {
        this.passengerId = id;
        this.passengerName = name;
        this.balance = balance;
        this.passengerTypeEnum = passengerTypeEnum;
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
            Activity activity
    ) {
        if (isPassengerAllowedForSubscription(
                this.passengerTypeEnum,
                activity.activityCost)) {
            switch (this.passengerTypeEnum) {
                case standard:
                    this.balance -= activity.activityCost;
                    break;
                case gold:
                    this.balance -= activity.activityCost * 0.9;
                    break;

                default:
                    break;
            }
            activity.onActivitySubscription(activity);
            this.subscribedActivityList.add(activity);
        }
    }

    public String getPassengerType(PassengerTypeEnum passengerTypeEnum) {
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

    public void printPassengerDetails(Passenger passenger) {
        Print.print("<----------- INFO Start :::: --------------->");
        Print.print("Passenger id : " + passenger.passengerId);
        Print.println();
        Print.print("Passenger name : " + passenger.passengerName);
        if (passenger.passengerTypeEnum != PassengerTypeEnum.premium) {

            Print.println();
            Print.print("Passenger balance : " + passenger.balance);
        }
        Print.println();
        Print.print("Passenger type : " + getPassengerType(passenger.passengerTypeEnum));

        Print.println();
        Print.print("Subscribed activity details");
        for (Activity activity : this.subscribedActivityList) {
            activity.printActivityDetails(this, activity);
        }

        Print.println();
        Print.print("<----------- INFO End :::: --------------->");

    }

}
