package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----Welcome to the Financial Calculator----");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Please select a calculator:");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Loan Calculator");
            System.out.println("3. Investment Calculator");
            System.out.println("4. Exit");

            //User input
            System.out.println("--------------------------");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mortgageCalculator(scanner);
                    break;
                case 2:
                    // Call loan calculator method
                    futureValue(scanner);
                    break;
                case 3:
                    // Call investment calculator method
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

    }

    public static void mortgageCalculator(Scanner scanner) {

        double principalAmount = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        int years = 0;

        System.out.println("\n----Mortgage Calculator----");
        System.out.print("Enter the principal amount: ");
        principalAmount = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage): ");
        interestRate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        years = scanner.nextInt();

        double monthlyInterestRate = interestRate / (12 * 100);
        double numberOfPayments = years * 12;
        double numerator = principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
        monthlyPayment = numerator / denominator;
        System.out.printf("A mortgage of %.2f at an interest rate of %.2f%% for %d years will have a monthly payment of %.2f.\n",
                principalAmount, interestRate, years, monthlyPayment);

    }

    public static void futureValue(Scanner scanner) {
        double principal = 0;
        double rate = 0;
        int years = 0;
        double futureValue = 0;

        System.out.println("\n----Future Value Calculator----");
        System.out.print("Enter the principal amount: ");
        principal = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage): ");
        rate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        years = scanner.nextInt();

        futureValue = principal * Math.pow(1 + (rate / 100), years);
        System.out.printf("The future value of an investment of %.2f at an interest rate of %.2f%% for %d years is %.2f.\n",
                principal, rate, years, futureValue);
    }

        public static void presentValue(Scanner scanner) {
        double futureValue = 0;
        double rate = 0;
        int years = 0;
        double presentValue = 0;

        System.out.println("\n----Present Value Calculator----");
        System.out.print("Enter the future value: ");
        futureValue = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in percentage):");
        rate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        years = scanner.nextInt();

        presentValue = futureValue / Math.pow(1 + (rate / 100), years);
        System.out.printf("The present value of an investment of %.2f at an interest rate of %.2f%% for %d years is %.2f.\n",
                futureValue, rate, years, presentValue);
    }

}
