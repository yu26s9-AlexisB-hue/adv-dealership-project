package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        //min and max, pass array list through it
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){

            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;

    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        //make, model  and array list
        List<Vehicle> matchingMakeModel = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)){
                matchingMakeModel.add(vehicle);
            }
        }
        return matchingMakeModel;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        //min and max year, pass array list through it
        List<Vehicle> matchVehicleYear = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                matchVehicleYear.add(vehicle);
            }
        }
        return matchVehicleYear;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        //color, pass array list through it
        List<Vehicle> matchColor = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                matchColor.add(vehicle);
            }
        }
        return matchColor;
    }
    public List<Vehicle> getVehiclesByMilage(double min, double max){
        //min and max, pass array list through it
        List<Vehicle> matchMilage = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                matchMilage.add(vehicle);
            }
        }
        return matchMilage;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        //Type, pass array list through it
        List<Vehicle> matchType = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                matchType.add(vehicle);
            }
        }
        return matchType;
    }
    public List<Vehicle> getAllVehicles(){
       return this.inventory;
    }
    public void addVehicle(Vehicle vehicle){
        //add vehicles to array list
        inventory.add(vehicle);
    }
    public void removeVehicle(int vehicleVin){

        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getVin() == vehicleVin){
                inventory.remove(i);
                System.out.println("Vehicle has been removed.");

                return;
            }
        }
        System.out.println("Vehicle not found.");

        //find the vehicle with that vin from the inventory, and remove it from the inventory...


        //remove vehicles from the array list.
//        System.out.println("What line would you like to delete? ");
//        int lineNumeber = scanner.nextInt();
//
//        for(Vehicle v : inventory){
//            inventory.remove(inventory.get(lineNumeber));
//            break;
//        }
    }
}

