public class BasicNestedLoops {
    public static void main(String[] args) {
        for(int i = 0; i < 6; i ++){
            String line = "";

            for (int j = 0; j < 6; j++){

                line = line + "("+i + ", "+ j + ") ";
            }
            System.out.println(line);
        }
    }
}
