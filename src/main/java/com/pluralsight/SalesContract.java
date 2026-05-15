package com.pluralsight;

import java.util.List;

public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String email, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, email, vehicleSold);
        this.isFinanced = isFinanced;
    }

    //decided to create a processing fee method instead of it being a private class
    public double getProccessingFee(){
        if(getVehicleSold().getPrice() < 10000){
            return 295;
        }else{
            return 495;
        }
    }

    public double getSalesTaxAmount(){
        return getVehicleSold().getPrice() * 0.05;
    }


    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice(){
        //todo: This is where I need to calculate every expense for the customer.
        double recordFee = 100;
        return  getVehicleSold().getPrice() + getSalesTaxAmount() + recordFee + getProccessingFee();
    }

    @Override
    public double getMonthlyPayment(){
        //todo: This is where the math in the payroll calculator comes in handy.
        if(isFinanced == true){
            double vehiclePrice = getTotalPrice();
            double annualRate;
            double n;
            if(vehiclePrice >= 10000){
                //todo:All loans are at 4.25% for 48 months if the price is $10,000 or more.
                annualRate = 0.0425;//4.25%
                n = 48; //48 months

            }else{
                //todo:Otherwise they are at 5.25% for 24 month
                annualRate = 0.0525; // 5.25% rate
                n = 24; // 24 months

            }
            double i = annualRate/12;

            //Monthly payment formula
            return vehiclePrice * (i * Math.pow(1 + i, n)/(Math.pow(1 + i, n) - 1));
        }else {
            return 0;
        }
    }
}
