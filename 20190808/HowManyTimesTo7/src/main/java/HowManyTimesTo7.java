import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;
        int diceTotal;
        int to7 = 1;
        int total7 = 1;
        boolean met7 = false;

        for (int i = 0; i < 100; i++) {
            dice1 = randomGenerator.nextInt(6) + 1;
            dice2 = randomGenerator.nextInt(6) + 1;
            diceTotal = dice1 + dice2;

            if (diceTotal == 7) {
                total7 += 1;
                met7 = true;
            } else if ((diceTotal != 7) && (met7 == false)){
                to7 += 1;
            }
        }
        System.out.println("It took " + to7 + " rolls to get to 7.");
        System.out.println("In total there were " + total7 + " sevens rolled");
    }
}
