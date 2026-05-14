package com.pluralsight;

import java.util.List;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String email, int vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, email, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue(double price) {
        double expectedValuePercentage = price * .5;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee(double price) {
        double fee = price * .07;
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice(){
        //todo: This is where I need to calculate every expense for the customer.
        return 0;
    }

    @Override
    public double getMonthlyPayment(double vehiclePrice){
        //todo: All leases are financed at 4.0% for 36 months
        return 0;
    }
}
