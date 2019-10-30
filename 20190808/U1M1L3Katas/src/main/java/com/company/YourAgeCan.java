package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age;

        System.out.println("How old are you?");
        age = Integer.parseInt(scan.nextLine());

        if (age >= 18) {
            System.out.println("You can vote");
        }

        if (age >= 21) {
            System.out.println("You can drink alcohol");
        }

        if (age >= 35) {
            System.out.println("You can be president");
        }

        if (age >= 55) {
            System.out.println("You are eligible for AARP");
        }

        if (age >= 65) {
            System.out.println("You can retire");
        }

        if (age <= 89 && age >=80) {
            System.out.println("You are an octogenerian");
        }

        if (age > 100) {
            System.out.println("You are more than a century old");
        }
    }
}
