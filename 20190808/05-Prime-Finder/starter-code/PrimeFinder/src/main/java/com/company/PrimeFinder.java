package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;
        System.out.println("Input a whole number");
        userInput = Integer.parseInt(scan.nextLine());
        int testNum;
        boolean isPrime;
        int currentInput;

        for (int i = 2; i <= userInput; i++) {
            currentInput = i;
            isPrime = true;
            for (int j = 2; j <= currentInput; j++) {
                testNum = j - 1;
                if ((currentInput % testNum == 0) && (testNum > 1)) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.println(currentInput);
            }
        }
    }
}
