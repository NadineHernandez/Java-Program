public class SomeMath {

    public static int total5(int a, int b, int c, int d, int e) {
        int sum = (a + b + c + d + e);
        return sum;
    }

    public static double average5(int a, int b, int c, int d, int e) {
        double avg = (a + b + c + d + e) / 5;
        return avg;
    }

    public static double largest5(double a, double b, double c, double d, double e) {
        double largest;
        double[] userInput = {a, b, c, d, e};

        //give largest a base comparison point besides 0 in case all numbers are negative
        if(a > b) {
            largest = a;
        } else {
            largest = b;
        }

        for(int i = 2;  i < 5; i++) {
            if (userInput[i] > largest) {
                largest = userInput[i];
            }
        }

        return largest;
    }
    public static void main(String[] args) {
        System.out.println(total5(1, 2, 3, 4, 5));
        System.out.println(average5(1, 3, 5, 7, 9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));
    }
}
