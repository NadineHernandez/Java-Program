package com.company;
import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String email;
        String twitterHandle;
        byte age;
        String country;
        String profession;
        String favOS;
        String favProgrammingLang;
        String favCompSci;
        String favKeyboard;
        String builtComp;
        String superhero;

        System.out.println("What is your first name?");
        firstName = scanner.nextLine();

        System.out.println("What is your last name?");
        lastName = scanner.nextLine();

        System.out.println("What is your email?");
        email = scanner.nextLine();

        System.out.println("What is your twitter handle?");
        twitterHandle = scanner.nextLine();

        System.out.println("How old are you?");
        age = Byte.parseByte(scanner.nextLine());

        System.out.println("What country are you from?");
        country = scanner.nextLine();

        System.out.println("What is your profession?");
        profession = scanner.nextLine();

        System.out.println("What is your favorite operating system?");
        favOS = scanner.nextLine();

        System.out.println("What is your favorite programming language?");
        favProgrammingLang = scanner.nextLine();

        System.out.println("What is your favorite computer scientist?");
        favCompSci = scanner.nextLine();

        System.out.println("What is your favorite keyboard shortcut?");
        favKeyboard = scanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        builtComp = scanner.nextLine();

        System.out.println("If you could be any superhero, who would you be?");
        superhero = scanner.nextLine();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(twitterHandle);
        System.out.println(age);
        System.out.println(country);
        System.out.println(profession);
        System.out.println(favOS);
        System.out.println(favProgrammingLang);
        System.out.println(favCompSci);
        System.out.println(favKeyboard);
        System.out.println(builtComp);
        System.out.println(superhero);
    }
}
