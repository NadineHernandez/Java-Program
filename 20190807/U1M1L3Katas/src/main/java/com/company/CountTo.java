package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        System.out.println("Input a number");
        userInput = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= userInput; i++) {
            System.out.println(i);
        }
    }
}
