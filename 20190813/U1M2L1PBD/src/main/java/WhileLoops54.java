import java.util.Random;
import java.util.Scanner;

public class WhileLoops54 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int guessCounter = 0;

        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");
        do {
            guess = Integer.parseInt(scan.nextLine());
            guessCounter += 1;

            if (guess > secretNumber) {
                System.out.println("Sorry, you are too high.");
            } else {
                System.out.println("Sorry, you are too low");
            }
        } while (guess != secretNumber && guessCounter < 7);

        if (guess == secretNumber) {
            System.out.println("You guessed it! What are the odds?!?");
        } else {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        }

    }
}
