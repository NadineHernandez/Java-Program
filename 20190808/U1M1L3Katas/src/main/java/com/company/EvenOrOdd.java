package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        System.out.println("Enter a whole number");
        userInput = Integer.parseInt(scan.nextLine());

        if (userInput%2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
