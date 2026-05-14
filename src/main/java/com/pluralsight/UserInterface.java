package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public void display(){
        init();
        boolean running = true;

        while(running){
            //Creating a variable to hold the prompts to ask the user.
            String prompt = """
                    1 - View By Price Range
                    2 - View By Make & Model
                    3 - View By Year
                    4 - View By Color
                    5 - View By Mileage
                    6 - View By Vehicle Type
                    7 - View All Vehicles
                    8 - Add To Inventory
                    9 - Remove From Inventory
                    0 - Exit
                    """;

            //Takes and returns the users input into the command.
            int command = Console.promptForInt(prompt);

            switch(command){
                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                default:
                    System.out.println("Invalid Entry.");
                    break;

                case 0:
//                    System.exit(0);
                    running = false;
                    break;
            }
        }
    }
    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }
    private void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    public void processGetByPriceRequest(){
        double minPrice = Console.promptForDouble("What is the minimum price to search for: ");
        double maxPrice = Console.promptForDouble("What is the maximum price to search for: ");
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));

    }
    public void processGetByMakeModelRequest(){
        String make = Console.promptForString("What is the Make of the Vehicle: ");
        String model = Console.promptForString("What is the Model of the Vehicle: ");
        displayVehicles(dealership.getVehiclesByMakeModel(make,model));
    }
    public void processGetByYearRequest(){
        int yearMin = Console.promptForInt("What is the oldest year to search for: ");
        int yearMax = Console.promptForInt("What is the newest year to search for: ");
        displayVehicles(dealership.getVehiclesByYear(yearMin, yearMax));
    }
    public void processGetByColorRequest(){
        String color = Console.promptForString("What colored vehicle would you like? ");
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest(){
        double milageMin = Console.promptForDouble("What is the minimum range of mileage that you would like to search: ");
        double milageMax = Console.promptForDouble("What is the maximum range of mileage that you would like to search: ");
        displayVehicles(dealership.getVehiclesByMilage(milageMin,milageMax));
    }
    public void processGetByVehicleTypeRequest(){
        String type = Console.promptForString("What type of vehicle do you want to search for: ");
        displayVehicles(dealership.getVehiclesByType(type));
    }
    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){
        //Add new vehicle to the array list
        int vin = Console.promptForInt("Vin: ");
        int year = Console.promptForInt("Year: ");
        String make = Console.promptForString("Make: ");
        String model = Console.promptForString("Model: ");
        String vehicleType = Console.promptForString("Vehicle Type: ");
        String color = Console.promptForString("Color: ");
        int odometer = Console.promptForInt("Odometer: ");
        double price = Console.promptForDouble("Price: ");

        Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        dealership.addVehicle(vehicle);

        //saving to transaction list
        DealershipFileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest(){
        int vin = Console.promptForInt("What is the Vin number of the car that you would like to remove: ");
        dealership.removeVehicle(vin);

        DealershipFileManager.saveDealership(dealership);
    }

}
