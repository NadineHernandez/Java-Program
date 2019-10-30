import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PBD181 {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            int num = random.nextInt(90) +10;
            randomList.add(num);
        }

        List<Integer> copyList = new ArrayList<>();

        for(int i = 0; i < randomList.size(); i++){
            copyList.add(randomList.get(i));
        }

        randomList.set((randomList.size()-1), -7);

        System.out.println("ArrayList 1: " + randomList);
        System.out.println("ArrayList 2: " + copyList);
    }
}
