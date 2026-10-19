package com.pluralsight;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Utilities.displayMenu();
            int selection = Integer.parseInt(scanner.nextLine());

            switch (selection) {
                case 1:
                    //System.out.println("mortgageCalculator: We Promise to not Scam You Out of Your Money!");
                    MortgageCalculator.run(scanner);
                    break;
                case 2:
                    //System.out.println("You have selected the Loan Calculator\nStill WIP...");
                    CDFutureValueCalculator.run(scanner);
                    break;
                case 3:
                    System.out.println("You have selected the Investment Calculator\nStill WIP...");
                    break;
                case 9:
                    System.out.print("Exiting the program. Thank you for using our services!");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose a valid option (1, 2, 3, 9).");
            }// switch

            if (selection == 9) {
                break; // Exit the loop and terminate the program
            }
        }// while

        scanner.close();
    }// main


}// class