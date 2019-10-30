package com.company.interfaces;

import java.util.Scanner;

public class Input implements UserIO{

    Scanner scan = new Scanner(System.in);

    String userInput;

    public int readInt(String prompt){
        System.out.println(prompt);
        userInput = scan.nextLine();
        return Integer.parseInt(userInput);
    }
    public long readLong(String prompt){
        System.out.println(prompt);
        userInput = scan.nextLine();
        return Long.parseLong(userInput);
    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        userInput = scan.nextLine();
        return Double.parseDouble(userInput);
    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        userInput = scan.nextLine();
        return Float.parseFloat(userInput);
    }
    public String readString(String prompt){
        System.out.println(prompt);
        userInput = scan.nextLine();
        return userInput;
    }
}
