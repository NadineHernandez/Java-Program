import java.util.Random;
import java.util.Scanner;

public class WhileLoops53 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(10) +1;
        int guess = 0;
        int guessCounter = 0;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        do {
            guess = Integer.parseInt(scan.nextLine());

            if (guess != secretNumber) {
                System.out.println("That is incorrect. Guess again.");
            }

            guessCounter += 1;

        } while (guess != secretNumber);

        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you " + guessCounter + " tries.");
    }
}
