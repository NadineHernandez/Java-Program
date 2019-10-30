package com.company.interfaces;

import java.util.Scanner;

public class BetterInput implements UserIO {
    Scanner scan = new Scanner(System.in);

    String userInput;

    public int readInt(String prompt){
        int output;
        try {
            System.out.println(prompt);
            userInput = scan.nextLine();
            output = Integer.parseInt(userInput);
        } catch (Exception e){
            return readInt(prompt);
    }
        return output;
    }
    public long readLong(String prompt){
        long output;
        try {
            System.out.println(prompt);
            userInput = scan.nextLine();
            output = Long.parseLong(userInput);
        } catch (Exception e){
            return readLong(prompt);
        }
        return output;
    }
    public double readDouble(String prompt){
        Double output;
        try {
            System.out.println(prompt);
            userInput = scan.nextLine();
            output = Double.parseDouble(userInput);
        } catch (Exception e){
            return readDouble(prompt);
        }
        return output;
    }
    public float readFloat(String prompt){
        Float output;
        try {
            System.out.println(prompt);
            userInput = scan.nextLine();
            output = Float.parseFloat(userInput);
        } catch (Exception e){
            return readFloat(prompt);
        }
        return output;
    }
    public String readString(String prompt){
        try {
            System.out.println(prompt);
            userInput = scan.nextLine();
        } catch (Exception e){
            return readString(prompt);
        }
        return userInput;
    }
}
