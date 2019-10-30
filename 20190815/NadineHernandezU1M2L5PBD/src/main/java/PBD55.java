import java.util.Scanner;

public class PBD55 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = 1;
        int total = 0;

        System.out.println("I will add up the numbers you give me.");

        while (number !=0) {
            number = Integer.parseInt(scan.nextLine());
            System.out.println("Number: " + number);
            total += number;
            if (number != 0) {
                System.out.println("The total so far is " + total);
            }
        }

        System.out.println("\n" +
                "The total is " + number);
    }
}
