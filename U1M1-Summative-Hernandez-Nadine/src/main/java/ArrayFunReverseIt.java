public class ArrayFunReverseIt {
    public static void main(String[] args) {

        int[] originalArr = {1, 2, 3, 4, 5};
        int[] reversedArr = new int[5];
        //counter that starts at the highest array index
        int counter = 4;

        for (int i = 0; i < 5; i++) {
            reversedArr[counter] = originalArr[i];
            counter -= 1;
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(originalArr[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(reversedArr[i]);
        }
    }
}
