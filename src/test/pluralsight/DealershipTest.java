package pluralsight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    void addVehicles() {
        ArrayList<Vehicle> inventory = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        //prompting the user
//        System.out.println("Vin: ");
        int vin = 10112; //scanner.nextInt();
        scanner.nextLine();
//        System.out.println("Year: ");
        int year = 1993;//scanner.nextInt();
        scanner.nextLine();
//        System.out.println("Make: ");
        String make = "Ford"; //scanner.nextLine();
//        System.out.println("Model: ");
        String model = "Explorer"; //scanner.nextLine();
//        System.out.println("Vehicle Type: ");
        String vehicleType = " SUV";//scanner.nextLine();
//        System.out.println("Color: ");
        String color = "RED"; //scanner.nextLine();
//        System.out.println("Odometer: ");
        int odometer = 525123;//scanner.nextInt();
        scanner.nextLine();
//        System.out.println("Price: ");
        double price = 995.00;//scanner.nextDouble();

        //creating a vehicle class
        Vehicle v = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);

        //Adding the vehicle to the ArrayList.
        inventory.add(v);

        System.out.println(inventory);

    }
}