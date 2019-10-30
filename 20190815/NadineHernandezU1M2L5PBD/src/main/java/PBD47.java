import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class PBD47 {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        Random random = new Random();

    String cup1 = "##";
    String cup2 = "##";
    String cup3 = "##";
    int secretNumber = random.nextInt(3) + 1;
    int guessedNumber = 0;

        System.out.println("You slide up to Fast Eddie's car table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards\n" +
                "\n" +
                "Which one is the ace?\n" +
                "\n" +
                "     " + cup1 + "  " + cup2 + "  " + cup3 +"\n" +
                "     " + cup1 + "  " + cup2 + "  " + cup3 +"\n" +
                "     1   2   3");

        guessedNumber = Integer.parseInt(scan.nextLine());

        switch (secretNumber) {
            case 1:
                cup1 = "AA";
                break;
            case 2:
                cup2 = "AA";
                break;
            case 3:
                cup3 = "AA";
                break;
        }
        if (guessedNumber == secretNumber) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + secretNumber + ".");
        }

        System.out.println("     " + cup1 + "  " + cup2 + "  " + cup3 +"\n" +
                "     " + cup1 + "  " + cup2 + "  " + cup3 +"\n" +
                "     1   2   3");
    }
}
