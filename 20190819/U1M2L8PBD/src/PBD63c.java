import java.util.Scanner;

public class PBD63c {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String player1;
        String player2 = "x";
        String playerTurn = player2;
        int pileA = 3;
        int pileB = 3;
        int pileC = 3;
        String pileChosen;
        int numChosen;
        String winner;

        System.out.println("Player 1, enter your name: ");
        player1 = scan.nextLine();

        System.out.println("Player 2, enter your name: ");
        player2 = scan.nextLine();

        while (pileA > 0 || pileB > 0 || pileC > 0) {
            if (playerTurn .equals(player1)){
                playerTurn = player2;
            } else {
                playerTurn = player1;
            }
            System.out.println("A: " + pileA + "   " + "B: " + pileB + "   " + "C: " + pileC);
            System.out.println("\n" +
                    playerTurn + ", choose a pile: ");
            pileChosen = scan.nextLine();

            System.out.println("How many to remove from pile " + pileChosen + ":");
            numChosen = Integer.parseInt(scan.nextLine());

            if (pileChosen.equals("A") || pileChosen.equals("a")){
                pileA -= numChosen;
            } else if (pileChosen.equals("B") || pileChosen.equals("b")){
                pileB -= numChosen;
            } else if (pileChosen.equals("C") || pileChosen.equals("c")){
                pileC = pileC - numChosen;
            }
        }
        System.out.println("\n" +
                "A: " + pileA + "   " + "B: " + pileB + "   " + "C: " + pileC);

        if (playerTurn.equals(player1)){
            winner = player2;
        } else {
            winner = player1;
        }

        System.out.println("\n" +
                winner + ", there are no counters left, so you WIN!");
    }
}
