package com.pluralsight;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true));
            if(contract instanceof SalesContract){
                SalesContract salesContract = (SalesContract) contract;

                String line = "Sale|"+
                        salesContract.getDate() +"|"+
                        salesContract.getCustomerName() +"|"+
                        salesContract.getEmail() + "|" +
                        salesContract.getVehicleSold().getVin() + "|" +
                        salesContract.getVehicleSold().getYear() + "|"+ "\n"+
                        salesContract.getVehicleSold().getMake() + "|"+
                        salesContract.getVehicleSold().getModel() +"|"+
                        salesContract.getVehicleSold().getVehicleType() + "|"+
                        salesContract.getVehicleSold().getColor() + "|"+
                        salesContract.getVehicleSold().getOdometer()+"|"+
                        salesContract.getVehicleSold().getPrice() + "|"+ "\n"+
                        salesContract.getSalesTaxAmount() + "|"+
                        salesContract.getRecordingFee() +"|"+
                        salesContract.getProccessingFee() + "|"+
                        salesContract.getTotalPrice() + "|"+
                        salesContract.isFinanced()+"|"+
                        salesContract.getMonthlyPayment() + "\n";


                writer.write(line);

            }else if (contract instanceof LeaseContract){
                LeaseContract lease = (LeaseContract) contract;

                String line = "LEASE|" +
                        lease.getDate() +"|"+
                        lease.getCustomerName() +"|"+
                        lease.getEmail() + "|" +
                        lease.getVehicleSold().getVin() + "|" +
                        lease.getVehicleSold().getYear() + "|"+ "\n"+
                        lease.getVehicleSold().getMake() + "|"+
                        lease.getVehicleSold().getModel() +"|"+
                        lease.getVehicleSold().getVehicleType() + "|"+
                        lease.getVehicleSold().getColor() + "|"+
                        lease.getVehicleSold().getOdometer()+"|"+
                        lease.getVehicleSold().getPrice() + "|"+ "\n"+
                        lease.getExpectedEndingValue() +"|"+
                        lease.getLeaseFee() +"|"+
                        lease.getTotalPrice() +"|"+
                        lease.getMonthlyPayment() + "\n";


                writer.write(line);

            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
