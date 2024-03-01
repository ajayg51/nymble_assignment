package com.example.nymble_assignment.classes;

import java.util.ArrayList;
import java.util.List;

import com.example.nymble_assignment.utils.Constants;
import com.example.nymble_assignment.utils.PassengerTypeEnum;
import com.example.nymble_assignment.utils.Print;

public class Passenger {
    private int destinationId;
    private int activityId;

    private int passengerId;
    private String passengerName;
    private double balance;
    private PassengerTypeEnum passengerType;
    private boolean isSubscribedToAnActivity;
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

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int id) {
        this.activityId = id;
    }

    public int getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(int id) {
        this.destinationId = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateBalance(double cost) {

        Print.println();
        Print.println();
        Print.print("Balance : passenger.java");
        Print.println();
        Print.print("bal : " + this.balance);

        Print.println();
        Print.print("bal ka 90% : " + (cost) + " " + (cost * 0.9));
        Print.println();

        switch (this.passengerType) {
            case standard:
                this.setBalance(this.balance - cost);

                break;
            case gold:
                this.setBalance(this.balance - (cost * 0.9));

                break;

            default:
                break;
        }

        Print.println();
        Print.print("Upadting passenger balance :: passenger.java ");
        Print.println();
        Print.print("ID : " + passengerId);
        Print.println();
        Print.print("balance before deduction : " + this.getBalance());
        Print.println();
        Print.print("  balance after deduction " + this.getBalance());
        Print.println();

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

    public boolean getIsSubscribedToAnActivity() {
        return this.isSubscribedToAnActivity;
    }

    public void setIsSubscribedToAnActivity(boolean isSubscribed) {
        this.isSubscribedToAnActivity = isSubscribed;
    }

    public List<Activity> getSubscribedActivityList() {
        return this.subscribedActivityList;
    }

    public void addActivityInList(Activity activity) {
        if (activity.getActivityId() != Constants.errorCode)
            this.subscribedActivityList.add(activity);
        else
            Print.print("activity found null in Passenger.java");

    }

    public boolean isPassengerAllowedForSubscription(
            Activity activity,
            TravelPackage travelPackage,
            PassengerTypeEnum passengerTypeEnum,

            double cost) {

        int travelPackagePassengerSize = travelPackage.getPassengerList().size();
        int travelPackageSubscribedListSize = travelPackage.getSubscribedPassengerList().size();

        int activityCapacity = activity.getActivityCapacity();

        Print.println();
        Print.println();
        Print.print("travel package passenger size : passenger.java :: " + travelPackagePassengerSize);
        Print.println();
        Print.print("activity capacity :: " + activityCapacity);
        Print.println();

        switch (passengerTypeEnum) {
            case standard:
            case gold:
                return travelPackagePassengerSize > travelPackageSubscribedListSize &&
                        activityCapacity > 0 &&
                        this.balance >= cost;
            case premium:

                return travelPackagePassengerSize > travelPackageSubscribedListSize &&
                        activityCapacity > 0;

            default:
                return false;
        }
    }

    public boolean subscribePassenger(
            Activity activity,
            TravelPackage travelPackage) {

        if (isPassengerAllowedForSubscription(
                activity,
                travelPackage,
                this.passengerType,
                activity.getActivityCost())) {

            Print.println();
            Print.print("Subscription allowed : Passenger.java");
            Print.println();
            return true;

        }
        Print.println();
        Print.print("Subscription failure : Passenger.java");
        Print.println();
        Print.print("Passenger balance is too low for subscription");
        Print.println();
        return false;
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
            Print.print("Passenger id :: Passenger File ::: " + passenger.passengerId);
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

            // if (this.subscribedActivityList != null) {
            // Print.println();
            // Print.println();
            // Print.println();
            // Print.print("Subscribed activity details");
            // Print.println();

            // for (Activity activity : this.subscribedActivityList) {
            // activity.printActivityDetails(activity, travelPackage);
            // }

            // } else
            // Print.print("subscribedActivityList found null in Passenger.java");

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
