import java.util.Random;
import java.util.Scanner;

public class RandomNumbers43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userAnswer1;
        int userAnswer2;
        int userAnswer3;

        Random random = new Random();

        int random1 = random.nextInt(10) + 1;
        int random2 = random.nextInt(10) + 1;
        int random3 = random.nextInt(10) + 1;

        System.out.println("I'm thinking of a number from 1 to 10.");
        userAnswer1 = Integer.parseInt(scan.nextLine());
        System.out.println("Your guess: " + userAnswer1);

        if (userAnswer1 == random1) {
            System.out.println("That's right! My secret number was " + random1 + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + random1);
        }

        System.out.println("I'm thinking of a number from 1 to 10.");
        userAnswer2 = Integer.parseInt(scan.nextLine());
        System.out.println("Your guess: " + userAnswer2);

        if (userAnswer2 == random2) {
            System.out.println("That's right! My secret number was " + random2 + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + random2);
        }

        System.out.println("I'm thinking of a number from 1 to 10.");
        userAnswer3 = Integer.parseInt(scan.nextLine());
        System.out.println("Your guess: " + userAnswer3);

        if (userAnswer3 == random3) {
            System.out.println("That's right! My secret number was " + random3 + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + random3);
        }
    }
}
