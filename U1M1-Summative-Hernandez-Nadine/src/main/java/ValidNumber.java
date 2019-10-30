import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userInput;

        do {
            System.out.println("Enter a number between 1 and 10");
            userInput = Integer.parseInt(scan.nextLine());

            if (userInput < 1 || userInput > 10) {
                System.out.println("You must enter a number between 1 and 10, please try again.");
            }
        } while (userInput < 1 || userInput > 10);

        System.out.println(userInput);
    }
}
