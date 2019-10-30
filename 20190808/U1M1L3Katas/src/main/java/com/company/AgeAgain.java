package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age;
        String grade;
        String answer;
        String college;
        String plan;
        String job;

        System.out.println("How old are you?");
        age = Integer.parseInt(scan.nextLine());

        if (age < 14) {
            System.out.println("What grade are you in?");
            grade = scan.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        } else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning to go to college?");
            answer = scan.nextLine();

            if (answer.equals("yes")) {
                System.out.println("Which college?");
                college = scan.nextLine();
                System.out.println(college + " is a great school!");
            } else if (answer.equals("no")) {
                System.out.println("What do you plan to do after High School?");
                plan = scan.nextLine();
                System.out.println("Wow, " + plan + " sounds like a plan!");
            }
        } else {
            System.out.println("What is your job?");
            job = scan.nextLine();
            System.out.println(job + " sounds like a great job!");
        }
    }
}
