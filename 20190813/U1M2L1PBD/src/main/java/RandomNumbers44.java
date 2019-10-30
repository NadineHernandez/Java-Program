import java.util.Random;

public class RandomNumbers44 {
    public static void main(String[] args) {
        Random random = new Random();

        int fortune = random.nextInt(6) + 1;
        int number1 = random.nextInt(54) +1;
        int number2 = random.nextInt(54) +1;
        int number3 = random.nextInt(54) +1;
        int number4 = random.nextInt(54) +1;
        int number5 = random.nextInt(54) +1;
        int number6 = random.nextInt(54) +1;

        switch (fortune) {
            case 1:
                System.out.println("You will meet someone important at an upcoming event.");
                break;
            case 2:
                System.out.println("Beware of birds in your future.");
                break;
            case 3:
                System.out.println("You will meet a stranger at dusk. Do NOT approach.");
                break;
            case 4:
                System.out.println("You will swallow only 9 spiders tonight. Sleep well.");
                break;
            case 5:
                System.out.println("They will see you and you will regret it.");
                break;
            case 6:
                System.out.println("Look forward to chocolate!");
                break;
            default:
                System.out.println("There is only void");
        }
        System.out.println(number1 + " - " + number2 + " - " + number3 + " - " + number4 + " - " + number5 + " - " + number6);
    }
}
