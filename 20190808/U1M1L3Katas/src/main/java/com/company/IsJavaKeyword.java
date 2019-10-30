package com.company;

import java.util.Scanner;
import javax.lang.model.SourceVersion;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userInput;

        System.out.println("Enter a word");
        userInput = scan.nextLine();

        //imported up top. Just determines if a word is a keyword using my input. returns true
        if (SourceVersion.isKeyword(userInput)) {
            System.out.println("is a java keyword");
        } else {
            System.out.println("not a java keyword");
        }
    }
}
