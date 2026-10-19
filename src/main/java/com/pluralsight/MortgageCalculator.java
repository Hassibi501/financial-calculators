package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    public static void run(Scanner scanner) {
        System.out.println("Mortgage Calculator: We Promise to not Scam You Out of Your Money!");

        double principal = Utilities.getValidInput(scanner, "Enter the principal amount (loan amount):");

        double annualInterestRate = Utilities.getValidInput(scanner, "Enter the annual interest rate:");

        int loanTermYears = (int) Utilities.getValidInput(scanner, "Enter the loan term in year:");
        System.out.println();

        System.out.printf("""
                Monthly Payment: $%.2f
                Total Interest Paid: $%.2f
                """, calculateMonthlyPayment(principal, annualInterestRate, loanTermYears), totalInterestPaid(principal, annualInterestRate, loanTermYears));

        System.out.println("\nExiting the Mortgage Calculator. Returning to the main menu...");
    }

    private static double calculateMonthlyPayment(double principal, double annualInterestRate, int loanTermYears) {
        // MonthlyPayment = (Principal * (MonthlyInterestRate * (1 + MonthlyInterestRate)^(12 * LoanTermYears))) / ((1 + MonthlyInterestRate)^(12 * LoanTermYears) - 1)
        //              M = P × (i × (1 + i)^n) / ((1 + i)^n - 1)

        // Numbers of monthly payments (n) = LoanTermYears * 12
        double numberOfMonthlyPayments = loanTermYears * 12;

        // Monthly Interest Rate (i) = Annual InterestRate / 12
        double monthlyInterestRate = annualInterestRate / 12 / 100; // Convert percentage to decimal

        // Calculate the monthly payment using the formula and returning the result
        return (principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments)))) / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
    }

    private static double totalInterestPaid(double principal, double monthlyPayment, int loanTermYears) {
        // Total Interest Paid = (MonthlyPayment * NumberOfMonthlyPayments) - Principal
        monthlyPayment = calculateMonthlyPayment(principal, monthlyPayment, loanTermYears);
        double numberOfMonthlyPayments = loanTermYears * 12;
        return (monthlyPayment * numberOfMonthlyPayments) - principal;
    }



}
