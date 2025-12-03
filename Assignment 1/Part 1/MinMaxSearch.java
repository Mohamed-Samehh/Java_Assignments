import java.util.Random;

public class MinMaxSearch {
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random random = new Random();
        
        // Fill array with random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        // Start timing
        long startTime = System.nanoTime();

        int min = numbers[0];
        int max = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // End timing
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("=== Min/Max Search Results ===");
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Search time: " + duration + " nanoseconds");
    }
}