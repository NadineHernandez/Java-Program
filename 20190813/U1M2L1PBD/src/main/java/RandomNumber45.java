import java.util.Random;

public class RandomNumber45 {

    public static void main(String[] args) {


        Random random = new Random();

        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;

        System.out.println("HERE COMES THE DICE!");
        System.out.println("roll #1: " + roll1);
        System.out.println("roll #2: " + roll2);
        System.out.println("The total is " + (roll1 + roll2) + "!");
    }
}
