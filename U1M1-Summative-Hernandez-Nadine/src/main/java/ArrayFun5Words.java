import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] userInput = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a word");
            userInput[i] = scan.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(userInput[i]);
        }
    }
}
