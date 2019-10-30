import java.util.Scanner;

public class IfStatements27 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int correct = 0;
        int userAnswer1;
        int userAnswer2;
        int userAnswer3;

        System.out.println("Q1) What is the capital of Alaska?\n" +
                "     1) Melbourne\n" +
                "     2) Anchorage\n" +
                "     3) Juneau\n");
        userAnswer1 = Integer.parseInt(scan.nextLine());

        if (userAnswer1 == 3) {
            correct++;
            System.out.println("That's right!");
        } else {
            System.out.println("Sorry, the correct answer was Juneau.");
        }


        System.out.println("Q2) Can you store value 'cat' in a variable of type int?\n" +
                "     1) yes" +
                "     2) no");
        userAnswer2 = Integer.parseInt(scan.nextLine());

        if (userAnswer2 == 2) {
            correct++;
            System.out.println("You got it!");
        } else {
            System.out.println("Sorry, 'cat' is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?\n" +
                "     1) 5" +
                "     2) 11" +
                "     3) 15/3");
        userAnswer3 = Integer.parseInt(scan.nextLine());

        if (userAnswer3 == 2) {
            correct++;
            System.out.println("That's correct");
        } else {
            System.out.println("Sorry, the answer was '11'.");
        }

        System.out.println("Overall, you got " + correct + " correct.");
    }
}
