package com.pluralsight;

import java.util.List;

public class LeaseContract extends Contract{

    public LeaseContract(String date, String customerName, String email, Vehicle vehicleSold) {
        super(date, customerName, email, vehicleSold);
    }

    public double getExpectedEndingValue(){
        return getVehicleSold().getPrice() * 0.50;
    }
    public double getLeaseFee(){
        return getVehicleSold().getPrice() * 0.07;
    }


    @Override
    public double getTotalPrice(){
        //todo: This is where I need to calculate every expense for the customer.
        return getVehicleSold().getPrice() + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment(){
        //todo: All leases are financed at 4.0% for 36 months
        double vehiclePrice = getTotalPrice();
        double annualRate = 0.04; // 4.0%
        double n = 36; // 36 months
        double i = annualRate / 12;

        return vehiclePrice * (i * Math.pow(1 + i, n)/(Math.pow(1 + i, n) - 1));
    }
}
