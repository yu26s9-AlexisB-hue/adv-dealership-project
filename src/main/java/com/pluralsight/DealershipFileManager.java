package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    public static Dealership getDealership(){

        Dealership dealership = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));

            String line = reader.readLine();

            // First line = dealership info
            if (line != null){
                String[] dealershipData = line.split("\\|");

                dealership = new Dealership(
                        dealershipData[0],
                        dealershipData[1],
                        dealershipData[2]
                );

                // Remaining lines = vehicles
                while ((line = reader.readLine()) != null){
                    String[] vehicleData = line.split("\\|");

                    // vin   year make   model tp  clr  miles  price
                    // 44901|2012|Honda|Civic|SUV|Gray|103221|6995.00
                    Vehicle vehicle = new Vehicle(
                            Integer.parseInt(vehicleData[0]), //vin
                            Integer.parseInt(vehicleData[1]), //year
                            vehicleData[2],
                            vehicleData[3],
                            vehicleData[4],
                            vehicleData[5],
                            Integer.parseInt(vehicleData[6]),
                            Double.parseDouble(vehicleData[7])
                    );
                    dealership.addVehicle(vehicle);
                }
            }
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dealership;
    }
    public static void saveDealership(Dealership dealership){
        try {
            FileWriter writer = new FileWriter("inventory.csv");

            //first add one line to represent the dealership
            writer.write(dealership.getName() + "|"+
                    dealership.getAddress() + "|" +
                    dealership.getPhone() + "\n");

            //then loop through each of the dealerships vehicles and for each vehicle add one line
            for(Vehicle vehicle : dealership.getAllVehicles()){
                writer.write(vehicle.getEncodedVehicleLine());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
