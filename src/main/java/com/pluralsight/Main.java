package com.pluralsight;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================================================================");
        System.out.println("Welcome to the You Will Get Finically Scammed Corporation!");
        System.out.println("===========================================================================================");
        System.out.println("Mortgage Calculator: We Promise to not Scam You Out of Your Money!");

        double principal = getValidInput(scanner, "Enter the principal amount (loan amount):");
        System.out.println();

        double annualInterestRate = getValidInput(scanner, "Enter the annual interest rate:");
        System.out.println();

        int loanTermYears = (int) getValidInput(scanner, "Enter the loan term in year:");
        System.out.println();

        System.out.printf("""
                Monthly Payment: $%.2f
                Total Interest Paid: $%.2f
                """, calculateMonthlyPayment(principal, annualInterestRate, loanTermYears), totalInterestPaid(principal, annualInterestRate, loanTermYears));

        scanner.close();
    }

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
    }

    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int loanTermYears) {
            // MonthlyPayment = (Principal * (MonthlyInterestRate * (1 + MonthlyInterestRate)^(12 * LoanTermYears))) / ((1 + MonthlyInterestRate)^(12 * LoanTermYears) - 1)
            //              M = P × (i × (1 + i)^n) / ((1 + i)^n - 1)

            // Numbers of monthly payments (n) = LoanTermYears * 12
            double numberOfMonthlyPayments = loanTermYears * 12;

            // Monthly Interest Rate (i) = Annual InterestRate / 12
            double monthlyInterestRate = annualInterestRate / 12 / 100; // Convert percentage to decimal

            // Calculate the monthly payment using the formula and returning the result
            return (principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments)))) / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
    }

    public static double totalInterestPaid(double principal, double monthlyPayment, int loanTermYears) {
        // Total Interest Paid = (MonthlyPayment * NumberOfMonthlyPayments) - Principal
        monthlyPayment = calculateMonthlyPayment(principal, monthlyPayment, loanTermYears);
        double numberOfMonthlyPayments = loanTermYears * 12;
        return (monthlyPayment * numberOfMonthlyPayments) - principal;
    }
}