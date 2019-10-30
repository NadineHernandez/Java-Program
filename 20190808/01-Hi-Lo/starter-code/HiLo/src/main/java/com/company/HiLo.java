package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("Welcome to Hi-Low!");
        String usersName;
        System.out.println("What is your name?");
        usersName = scan.nextLine();

        System.out.println("OK, " + usersName + ", here are the rules:");
        System.out.println("The computer will choose a random number between 1 and 100 and you want to match it.");

        //generate random number
        int randomInt = randomGenerator.nextInt(100) + 1;
        int userGuess = 0;
        int guessCount = 0;

        while (randomInt != userGuess) {
            System.out.println("Guess a number");
            //take in user guess
            userGuess = Integer.parseInt(scan.nextLine());
            //increment guess count
            guessCount = guessCount += 1;

            //compare user guess to random number and give feedback
            if (userGuess < randomInt) {
                System.out.println("Too low!");
            } else if (userGuess > randomInt) {
                    System.out.println("Too high!");
                }
            }

        System.out.println("Congratulations, " + usersName + "! You win!");
        System.out.println("It took you " + guessCount + " guesses to find my number!");
    }
}
