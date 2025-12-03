import java.util.Random;
import java.util.Arrays;

public class BinarySearchDemo {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (array[middle] == target) {
                return middle;
            }
            
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return -1; // Not found
    }
    
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random random = new Random();
        
        // Fill array with random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }
        
        // Sort array for binary search (binary search requires sorted array)
        Arrays.sort(numbers);
        
        // Choose a random target to search for
        int target = numbers[random.nextInt(numbers.length)];
        
        // Measure linear search time (for comparison)
        long linearStartTime = System.nanoTime();
        int linearResult = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                linearResult = i;
                break;
            }
        }
        long linearEndTime = System.nanoTime();
        long linearDuration = linearEndTime - linearStartTime;

        long binaryStartTime = System.nanoTime();
        int binaryResult = binarySearch(numbers, target);
        long binaryEndTime = System.nanoTime();
        long binaryDuration = binaryEndTime - binaryStartTime;

        System.out.println("Array size: " + numbers.length + " elements");
        System.out.println("Searching for: " + target);
        
        System.out.println("\n--- Linear Search ---");
        System.out.println("Found at index: " + linearResult);
        System.out.println("Time: " + linearDuration + " nanoseconds");
        
        System.out.println("\n--- Binary Search ---");
        System.out.println("Found at index: " + binaryResult);
        System.out.println("Time: " + binaryDuration + " nanoseconds");
    }
}