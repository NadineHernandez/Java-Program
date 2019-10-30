package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length;
        int width;

        System.out.println("What is the length of the driveway?");
        length = Integer.parseInt(scanner.nextLine());

        System.out.println("What is the width of the driveway?");
        width = Integer.parseInt(scanner.nextLine());

        int area = length * width;
        int perimeter = (length + width) * 2;

        System.out.println("The area of the driveway is " + area + "sq ft");
        System.out.println("The perimeter of the driveway is " + perimeter + "ft");

        float cementCost = area * 12.50f;
        float framingCost = perimeter * 8.25f;
        float totalCost = cementCost + framingCost;
        DecimalFormat df = new DecimalFormat( "0.00");

        System.out.println("Cement Cost: $" + df.format(cementCost));
        System.out.println("Framing Cost: $" + df.format(framingCost));
        System.out.println("Total Cost: $" + df.format(totalCost));

        float cementPrice;
        float framingPrice;

        System.out.println("What is the cost of cement?");
        cementPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("What is the cost of framing?");
        framingPrice = Float.parseFloat(scanner.nextLine());

        cementCost = area * cementPrice;
        framingCost = perimeter * framingPrice;
        totalCost = cementCost + framingCost;

        System.out.println("Cement Cost: $" + df.format(cementCost));
        System.out.println("Framing Cost: $" + df.format(framingCost));
        System.out.println("Total Cost: $" + df.format(totalCost));
    }
}
