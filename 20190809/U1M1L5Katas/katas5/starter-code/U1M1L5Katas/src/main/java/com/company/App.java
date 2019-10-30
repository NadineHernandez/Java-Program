package com.company;


import java.util.Scanner;

public class App {
    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int difference = a - b;

        if (difference >= 0) {
            return difference;
        } else {
            return 0;
        }
    }

    public static int max(int a, int b, int c) {
        int biggest;

        if (a > b) {
            biggest = a;
            if (a < c) {
                biggest = c;
            }
        } else if (b > c) {
            biggest = b;
        } else {
            biggest = c;
        }

        return biggest;
    }

    public static int min(int a, int b, int c) {
        int smallest;

        if (a < b) {
            smallest = a;
            if (a > c) {
                smallest = c;
            }
        } else if (b < c) {
            smallest = b;
        } else {
            smallest = c;
        }

        return smallest;
    }

    public static boolean isLarger(int a, int b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a;
        int b;
        int c;

        System.out.println("Input a number");
        a = Integer.parseInt(scan.nextLine());

        System.out.println("Input another number");
        b = Integer.parseInt(scan.nextLine());

        System.out.println("Input another number");
        c = Integer.parseInt(scan.nextLine());

        int sum = subtract(a, b);
        int maxi = max(a, b, c);
        int mini = min(a, b, c);
        boolean larger = isLarger(a, b);

        System.out.println(sum);
        System.out.println(maxi);
        System.out.println(mini);
        System.out.println(larger);

    }
}
