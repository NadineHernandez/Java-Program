package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        do {
            System.out.println("Enter a whole number between 15 and 32");
            userInput = Integer.parseInt(scan.nextLine());
        } while ((userInput >= 32) || (userInput <= 15));

        System.out.println(userInput);
    }
}
