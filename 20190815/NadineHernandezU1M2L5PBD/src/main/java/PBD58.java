import java.util.Random;

public class PBD58 {
    public static void main(String[] args) {
        Random random = new Random();
        int dice1;
        int dice2;

        System.out.println("HERE COMES THE DICE!");

        do {
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            System.out.println("Roll #1: " + dice1);
            System.out.println("Roll #2: " + dice2);

            int total = dice1 + dice2;

            System.out.println("The total is " + total + "!");
        } while (dice1 != dice2);
    }
}
