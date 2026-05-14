package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for a double.
     * @param prompt to display the user
     * @return the double the user selected.
     */
    public static double promptForDouble(String prompt) {
//Taking note of what changed for the int
//        System.out.print(prompt);
//        double result =  scanner.nextDouble();
//        scanner.nextLine();
//        return result;
        System.out.println(prompt);
        double result;
        while(true){
            try {
                result = scanner.nextDouble();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Invalid selection, please enter a number: ");
            }
        }

    }

    /**
     * Prompts the user for a string.
     * @param prompt to display the user
     * @return the string the user selected.
     */
    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Prompts the user for an integer.
     * @param prompt to display the user
     * @return the int the user selected.
     */
    public static int promptForInt(String prompt) {
// This is the older/original way to prompt for this
//        System.out.print(prompt);
//        int result =  scanner.nextInt();
//        scanner.nextLine();
//        return result;

        //This a new way to prompt the user and check for incorrect entries.
        System.out.println(prompt);
        int result;
        while(true){
            try{
                result = scanner.nextInt();
                scanner.nextLine();

                return result;
            } catch (InputMismatchException e) {
                System.out.println("Invalid selection, please enter a number: ");
            }
            scanner.nextLine();
        }

    }

    /**
     * Prompts the user for a Yes or No which is returned as a boolean.
     * @param prompt to display the user
     * @return the boolean
     */
    public static boolean promptForYesNo(String prompt) {
        System.out.print(prompt);
        String userInput = scanner.nextLine();
        return userInput.equalsIgnoreCase("YES");
        //opportunity to enhance this with some error protection.
    }

}