package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        System.out.println("Enter a whole number");
        userInput = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= userInput; i +=13) {
            System.out.println(i);
        }
    }
}