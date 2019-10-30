package com.company;

import java.util.Scanner;
import java.lang.Math;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double amount;
        double term;
        double annualRate;

        System.out.println("Input amount of mortgage");
        amount = Double.parseDouble(scan.nextLine());

        System.out.println("Input mortgage term");
        term = Double.parseDouble(scan.nextLine());

        System.out.println("Input annual rate of mortgage");
        annualRate = Double.parseDouble(scan.nextLine());

        double monthlyInterest = (annualRate / 100 / 12);

        double plusMonthly = (1 + monthlyInterest);

        //this wanted to be a double but I needed a float so (float) at the beginning fixed it
        //changed everything back to double though
        double poweredMonthly = Math.pow(plusMonthly, term);

        double paymentAmt = (amount * (monthlyInterest * poweredMonthly) / (poweredMonthly - 1));

        System.out.println(paymentAmt);
    }
}
