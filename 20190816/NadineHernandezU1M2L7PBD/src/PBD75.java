import java.util.Random;

public class PBD75 {

    public static void main(String[] args) {
        Random random = new Random();
        int playerCard1 = random.nextInt(10) +1;
        int playerCard2 = random.nextInt(10) +1;
        int dealerCard1 = random.nextInt(10) +1;
        int dealerCard2 = random.nextInt(10) +1;
        int playerTotal = playerCard1 + playerCard2;
        int dealerTotal = dealerCard1 + dealerCard2;

        System.out.println("You drew " + playerCard1 + " and " + playerCard2 + ".");
        System.out.println("Your total is " + playerTotal + ".");

        System.out.println("\n" +
                "The dealer has " + dealerCard1 + " and " + dealerCard2 + ".");
        System.out.println("Dealer's total is " + dealerTotal + ".");

        if (playerTotal > dealerTotal) {
            System.out.println("\n" +
                    "YOU WIN!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("\n" +
                    "YOU LOOSE!");
        } else {
            System.out.println("\n" +
                    "IT'S A TIE!");
        }
    }
}
