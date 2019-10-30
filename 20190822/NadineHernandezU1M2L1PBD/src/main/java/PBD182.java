import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PBD182 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userInput;
        List<Integer> randomList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            int num = random.nextInt(50) +1;
            randomList.add(num);
        }

        System.out.println("ArrayList: " + randomList);

        System.out.println("Value to find: ");
        userInput = Integer.parseInt(scanner.nextLine());

        if(randomList.contains(userInput)){
            System.out.println(userInput + " is in the ArrayList.");
        }
    }
}
