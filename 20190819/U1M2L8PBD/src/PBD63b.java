import java.util.Scanner;

public class PBD63b {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pileA = 3;
        int pileB = 3;
        int pileC = 3;
        String pileChosen;
        int numChosen;

        while (pileA > 0 || pileB > 0 || pileC > 0) {
            System.out.println("A: " + pileA + "   " + "B: " + pileB + "   " + "C: " + pileC);

            System.out.println("\n" +
                    "Choose a pile: ");
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
        System.out.println("\n" +
                "All piles are empty. Good job!");
    }
}
