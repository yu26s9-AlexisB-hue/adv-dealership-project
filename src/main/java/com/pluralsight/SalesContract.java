package com.pluralsight;

import java.util.List;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String email, int vehicleSold, double salesTaxAmount, double recordFee, double processingFee, boolean isFinanced) {
        super(date, customerName, email, vehicleSold);
        this.salesTaxAmount = 0.05;
        this.recordFee = 100;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordFee() {
        return recordFee;
    }

    public void setRecordFee(double recordFee) {
        this.recordFee = recordFee;
    }

    public double getProcessingFee(double vehiclePrice) {
        //Figure what processing fee the customer will be charged.
        if(vehiclePrice < 10000){
            processingFee = 295;
        }else{
            processingFee = 495;
        }

        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
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
        return 0;
    }

    @Override
    public double getMonthlyPayment(double vehiclePrice){
        //todo: This is where the math in the payroll calculator comes in handy.
        if(isFinanced == true){
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
