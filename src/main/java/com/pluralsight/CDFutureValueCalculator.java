package com.pluralsight;

import java.util.Scanner;

public class CDFutureValueCalculator {

    public static void run(Scanner scanner) {
        System.out.println("CD Future Value Calculator: We Promise to not Scam You Out of Your Money!");
        // Implementation for the CDFutureValueCalculator goes here

        double initialDepositAmount = Utilities.getValidInput(scanner, "Enter the initial deposit amount:");

        double annualInterestRate = Utilities.getValidInput(scanner, "Enter the annual interest rate:");

        double totalNumberOfYears = Utilities.getValidInput(scanner, "Enter the total number of years:");

        System.out.printf("""
                CD's Ending Balance(Future Value): $%.2f
                Total Interest Earned: $%.2f
                """,calculateFutureValue(initialDepositAmount, annualInterestRate, totalNumberOfYears)
                   ,calculateTotalInterestEarned(initialDepositAmount, annualInterestRate, totalNumberOfYears));

        System.out.println("\nExiting the CD Future Value Calculator. Returning to the Main Menu...");

    }

    private static double calculateFutureValue(double initialDepositAmount, double annualInterestRate, double totalNumberOfYears) {
        //                Principal = initialDepositAmount
        // Future Value = InitialDepositAmount * (1 + (AnnualInterestRate/DaysPerYear(365)))^(DaysPerYear(365) * Years)
        //           FV = P × (1 + (r / d))^n

        // DaysPerYear(d) = 365
        double daysPerYear = 365;

        // Daily Interest Rate (r/d) = AnnualInterestRate / DaysPerYear(365)
        double dailyInterestRate = annualInterestRate / daysPerYear / 100; // 100 - Convert percentage to decimal

        // Total Number of Days (n) = DaysPerYear(365) * Years
        double totalNumberOfDays = daysPerYear * totalNumberOfYears;

        // Calculate the future value using the formula and returning the result
        return initialDepositAmount * Math.pow((1 + dailyInterestRate), totalNumberOfDays);
    }

    private static double calculateTotalInterestEarned(double initialDepositAmount, double annualInterestRate, double totalNumberOfYears) {
        // Total Interest Earned = FutureValue - InitialDepositAmount(Principal)
        return calculateFutureValue(initialDepositAmount, annualInterestRate, totalNumberOfYears) - initialDepositAmount;
    }
}
