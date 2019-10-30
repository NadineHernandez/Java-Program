import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //create an empty array with a length of 5
        int[] userInput = new int[5];

        //ask for a number 5 times and assign the user input to the corresponding array index
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter a whole number.");
            userInput[i] = Integer.parseInt(scan.nextLine());
        }

        //loop through the array and print out each index
        for(int i = 0; i < 5; i++) {
            System.out.println(userInput[i]);
        }
    }
}
