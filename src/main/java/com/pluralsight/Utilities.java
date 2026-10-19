package com.pluralsight;

import java.util.Scanner;

public class Utilities {
    public static double getValidInput(Scanner scanner, String promptMessage) {
        while (true) {
            System.out.println(promptMessage);
            String input = scanner.nextLine();

            if (!input.matches("\\d+(\\.\\d+)?")) { // Regex to check for numeric input (integer or decimal)
                System.out.println("Error: The input should be numeric (no symbols) and positive\n");
                continue;
            }

            return Double.parseDouble(input);
        }
    }//getValidInput

    public static void displayMenu() {
        System.out.println("===========================================================================================");
        System.out.println("Welcome to the You Will Get Finically Scammed Corporation!");
        System.out.println("===========================================================================================");

        System.out.println();

        System.out.println("Please select a calculator from the following options:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Loan Calculator");
        System.out.println("3. Investment Calculator");
        System.out.println("9. Exit the program");
        System.out.println("Enter the number corresponding to your choice (1, 2, 3, 9):");
    }
}
