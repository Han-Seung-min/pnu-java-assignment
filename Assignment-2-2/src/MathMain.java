import java.util.Scanner;
import java.util.Arrays;

public class MathMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter N: ");
        int input = scanner.nextInt();
        scanner.close();

        //make array
        int[] inputs = new int[input];
        for (int i = 0; i < input; i++) {
            inputs[i] = i+1;
        }

        int max = getMax(inputs);
        System.out.printf("Max element : %d in %s%n", max, Arrays.toString(inputs));

        int min = getMin(inputs);
        System.out.printf("Min element : %d in %s%n", min, Arrays.toString(inputs));
    }

    protected static int getMax(int[] inputs) {
        int maxIndex = 0;
        for (int i = 0; i < inputs.length; i++) {
            int max = inputs[maxIndex];
            int current = inputs[i];
            if(current > max)
                maxIndex = i;
        }
        return inputs[maxIndex];
    }

    protected static int getMin(int[] inputs) {
        int minIndex = 0;
        for (int i = 0; i < inputs.length; i++) {
            int min = inputs[minIndex];
            int current = inputs[i];
            if(current < min)
                minIndex = i;
        }
        return inputs[minIndex];
    }
}
