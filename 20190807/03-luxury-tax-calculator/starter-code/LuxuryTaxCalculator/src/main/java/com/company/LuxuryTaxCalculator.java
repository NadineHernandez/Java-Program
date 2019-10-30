package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float salaryP1;
        float salaryP2;
        float salaryP3;
        float totalSalary;
        DecimalFormat df = new DecimalFormat( "0.00");
        float spendingLimit = 40000000;

        System.out.println("What is the salary for Player 1?");
        salaryP1 = Float.parseFloat(scanner.nextLine());

        System.out.println("What is the salary for Player 2?");
        salaryP2 = Float.parseFloat(scanner.nextLine());

        System.out.println("What is the salary for Player 3?");
        salaryP3 = Float.parseFloat(scanner.nextLine());

        totalSalary = salaryP1 + salaryP2 + salaryP3;
        System.out.println("Total Combined Salaries: $" + df.format(totalSalary));

        if (totalSalary > spendingLimit) {
            float taxable = totalSalary - spendingLimit;
            float luxTax = taxable * 0.18f;
            System.out.println("Luxury Tax: $" + df.format(luxTax));
        }
    }
}
