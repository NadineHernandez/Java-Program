public class CalculatorObject {

    //takes in two integers, calculates the sum, and prints out the equation
    public void add(int a, int b){
        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }

    //takes in two doubles, calculates the sum, and prints out the equation. overloaded method
    public void add(double a, double b){
        double sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }

    //takes in two integers, calculates the difference, and prints out the equation
    public void subtract(int a, int b){
        int diff = a - b;
        System.out.println(a + " - " + b + " = " + diff);
    }

    //takes in two doubles, calculate the difference, and prints out the equation. overloaded method
    public void subtract(double a, double b){
        double diff = a - b;
        System.out.println(a + " - " + b + " = " + diff);
    }

    //takes in two integers, calculates the product, and prints out the equation.
    public void multiply(int a, int b){
        int prod = a * b;
        System.out.println(a + " * " + b + " = " + prod);
    }

    //takes in two doubles, calculates the product, and prints out the equation. overloaded method
    public void multiply(double a, double b){
        double prod = a * b;
        System.out.println(a + " * " + b + " = " + prod);
    }

    //takes in two integers, divides a by b, and prints out the equation.
    public void divide(int a, int b){
        int div = a / b;
        System.out.println(a + " / " + b + " = " + div);
    }

    //takes in two doubles, divides a by b, and prints out the equation. overloaded method
    public void divide(double a, double b){
        double div = a / b;
        System.out.println(a + " / " + b + " = " + div);
    }
}
