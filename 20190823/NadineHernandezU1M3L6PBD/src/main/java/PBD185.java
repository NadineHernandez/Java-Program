import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PBD185 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userInput;
        List<Integer> randomList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            int num = random.nextInt(100) +1;
            randomList.add(num);
        }

        System.out.println("ArrayList: " + randomList);

        int bigNum = randomList.get(0);

        for (int i = 1; i < randomList.size(); i++){
            if (randomList.get(i) > bigNum) {
                bigNum = randomList.get(i);
            }
        }

        System.out.println("The largest value is " + bigNum);
    }
}
