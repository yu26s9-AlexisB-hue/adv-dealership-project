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

    public double getProcessingFee() {
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
    public double getMonthlyPayment(){
        //todo: This is where the math in the payroll calculator comes in handy.
        return 0;
    }
}
