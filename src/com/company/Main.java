package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MONTHS = 12;
        final int PERCENT = 100;

        int Principal;
        double monthlyInterest;
        int numberOfPayment;


        Scanner scanner = new Scanner(System.in);

        System.out.println("This programme is used to calculate mortgages.");
        System.out.println("");

        System.out.println("A mortgage, or a mortgage loan, is an agreement between you (the borrower) and a mortgage lender to buy or refinance a home without having all the cash upfront.\nThis agreement gives lenders the legal rights to repossess a property if you fail to meet the terms of your mortgage, most commonly by not repaying the money you’ve borrowed plus interest.");
        System.out.println("");

        System.out.println("Principal: This is the amount you borrowed from the lender.\n" +
                "Interest: This is what the lender charges you to lend you the money. Interest rates are expressed as an annual percentage.");
        System.out.println("");

        System.out.println("Please fill in the necessary information in order to calculate your mortgage.");
        System.out.println("");

        while (true) {
            System.out.print("Principal(Ghc1k - Ghc1M): ");
            Principal = scanner.nextInt();
            if (Principal >= 1000 && Principal <= 1000000)
                break;
                System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
           double annualInterest = scanner.nextDouble();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period(Years): ");
            int years = scanner.nextInt();
            if (years >= 1 && years <= 30) {
                numberOfPayment = years * MONTHS;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = Principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment))
                / (Math.pow(1+ monthlyInterest, numberOfPayment) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);
    }
}
