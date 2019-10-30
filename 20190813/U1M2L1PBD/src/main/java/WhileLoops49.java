import java.util.Random;
import java.util.Scanner;

public class WhileLoops49 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int secretNumber = random.nextInt(10) + 1;
        int guess = 0;

        do {
            System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
            guess = Integer.parseInt(scan.nextLine());
        } while (guess != secretNumber);

        System.out.println("That's right! You're a good guesser.");
    }
}
