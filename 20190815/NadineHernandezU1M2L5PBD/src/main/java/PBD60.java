import java.util.Scanner;

public class PBD60 {
    public static void main(String[] args) {


    Scanner scan = new Scanner(System.in);

    int userInput;
    double squareRoot;

        System.out.println("SQUARE ROOT! \n" +
                "Enter a number: ");
        userInput = Integer.parseInt(scan.nextLine());
        while (userInput < 0) {
            System.out.println("You can't take the square root of a negative number, silly.\n" +
                    "Try again: ");
            userInput = Integer.parseInt(scan.nextLine());
        }

        squareRoot = Math.sqrt(userInput);
        System.out.println("The square root of " + userInput + " is " + squareRoot);
    }
}
