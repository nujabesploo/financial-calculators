package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Welcome to the Financial Calculator ----");

        boolean isRunning = true;
        while (isRunning) {
            // Display menu options
            System.out.println("\nPlease select a calculator:");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Loan Future Value Calculator");
            System.out.println("3. Investment Present Value Calculator");
            System.out.println("4. Exit");
            System.out.println("--------------------------");

            // Get user choice
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mortgageCalculator(scanner);
                    break;
                case 2:
                    futureValue(scanner);
                    break;
                case 3:
                    presentValue(scanner);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Financial Calculator. Goodbye!");
        scanner.close(); // Close scanner to prevent resource leaks
    }

    /**
     * Mortgage Calculator - Computes monthly mortgage payments.
     */
    public static void mortgageCalculator(Scanner scanner) {
        System.out.println("\n---- Mortgage Calculator ----");

        // Get user input
        System.out.print("Enter the loan amount (principal): ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter the loan term (years): ");
        int years = scanner.nextInt();

        // Convert annual interest rate to monthly rate and years to months
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int totalPayments = years * 12;

        // Calculate monthly mortgage payment
        double monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments))
                / (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);

        // Display result
        System.out.printf("A mortgage of $%.2f at an interest rate of %.2f%% for %d years will have a monthly payment of $%.2f.\n",
                principal, annualInterestRate, years, monthlyPayment);
    }

    /**
     * Future Value Calculator - Calculates the future value of an investment.
     */
    public static void futureValue(Scanner scanner) {
        System.out.println("\n---- Future Value Calculator ----");

        // Get user input
        System.out.print("Enter the initial investment amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate future value
        double futureValue = principal * Math.pow(1 + (rate / 100), years);

        // Display result
        System.out.printf("The future value of an investment of $%.2f at an interest rate of %.2f%% for %d years is $%.2f.\n",
                principal, rate, years, futureValue);
    }

    /**
     * Present Value Calculator - Computes present value of a future investment.
     */
    public static void presentValue(Scanner scanner) {
        System.out.println("\n---- Present Value Calculator ----");

        // Get user input
        System.out.print("Enter the future value: ");
        double futureValue = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate present value
        double presentValue = futureValue / Math.pow(1 + (rate / 100), years);

        // Display result
        System.out.printf("The present value of $%.2f at an interest rate of %.2f%% for %d years is $%.2f.\n",
                futureValue, rate, years, presentValue);
    }
}
