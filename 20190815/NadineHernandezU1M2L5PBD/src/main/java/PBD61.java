import java.util.Scanner;

public class PBD61 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int side1;
        int side2;
        int side3;

        System.out.println("Enter three integers:");
        side1 = Integer.parseInt(scan.nextLine());
        System.out.println("Side 1: " + side1);

        side2 = Integer.parseInt(scan.nextLine());

        while (side2 < side1){
            System.out.println(side2 + " is smaller than " + side1 + ".   Try again.");
            side2 = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Side 2: " + side2);

        side3 = Integer.parseInt(scan.nextLine());

        while (side3 < side2){
            System.out.println(side3 + " is smaller than " + side2 + ".   Try again.");
            side3 = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Side 3: " + side3);

        //math for determining if it is a right triangle
        int c = (side1*side1) + (side2*side2);


        System.out.println("\n" +
                "Your three sides are " + side1 + " " + side2 + " " + side3);
        if (c == (side3 * side3)) {
            System.out.println("These sides *do* make a right triangle. Yippy skippy!");
        } else {
            System.out.println("NO! These sides do not make a right triangle.");
        }
    }
}
