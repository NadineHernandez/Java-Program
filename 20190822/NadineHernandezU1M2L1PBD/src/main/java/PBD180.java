import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PBD180 {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            int num = random.nextInt(90) +10;
            randomList.add(num);
        }

        System.out.println("ArrayList: " + randomList);
    }
}
