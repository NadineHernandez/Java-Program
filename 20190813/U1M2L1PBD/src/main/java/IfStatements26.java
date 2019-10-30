import java.util.Scanner;

public class IfStatements26 {

    public static double convertWeight(double earthWeight, int planet) {
        double convertedWeight;

        switch (planet) {
            case 1:
                convertedWeight = earthWeight * 0.78;
                break;
            case 2:
                convertedWeight = earthWeight * 0.39;
                break;
            case 3:
                convertedWeight = earthWeight * 2.65;
                break;
            case 4:
                convertedWeight = earthWeight * 1.17;
                break;
            case 5:
                convertedWeight = earthWeight * 1.05;
                break;
            case 6:
                convertedWeight = earthWeight * 1.23;
                break;
            default:
                convertedWeight = earthWeight;
                break;
        }

        return convertedWeight;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double earthWeight;
        int planet;

        System.out.println("Please enter your current earth weight");
        earthWeight = Double.parseDouble(scan.nextLine());

        System.out.println("I have information for the following planets:\n" +
                "1.Venus   2.Mars   3.Jupiter\n" +
                "4.Saturn   5.Uranus   6.Neptune");

        System.out.println("Which planet are you visiting?");
        planet = Integer.parseInt(scan.nextLine());

        System.out.println("Your weight would be " + convertWeight(earthWeight, planet) + " pounds on that planet.");
        }
    }
