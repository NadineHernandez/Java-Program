import java.util.ArrayList;
import java.util.List;

public class PbdIndvDigits {
    public static void main(String[] args) {

        for (Integer i = 1; i < 10; i++){
            String num1 = i.toString();
            String num2;
            int sum;
            for(Integer j = 0; j < 10; j++){
                num2 = j.toString();
                sum = i + j;

                System.out.println(num1 + num2 + ", " + num1 + " + " + num2 + " = " + sum);
            }
        }

    }

}
