import java.util.Scanner;
import java.util.function.Function;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Enter coefficient a: ");
            double a = input.nextDouble();
            
            System.out.print("Enter coefficient b: ");
            double b = input.nextDouble();
            
            System.out.print("Enter coefficient c: ");
            double c = input.nextDouble();
            
            // Function to calculate discriminant
            Function<double[], Double> discriminant = arr -> 
                arr[1] * arr[1] - 4 * arr[0] * arr[2];
            
            // Function to calculate first root (-b + √discriminant) / 2a
            Function<double[], Double> root1 = arr -> 
                (-arr[1] + Math.sqrt(discriminant.apply(arr))) / (2 * arr[0]);
            
            // Function to calculate second root (-b - √discriminant) / 2a
            Function<double[], Double> root2 = arr -> 
                (-arr[1] - Math.sqrt(discriminant.apply(arr))) / (2 * arr[0]);
            
            // Calculate and display
            double[] coefficients = {a, b, c};
            double d = discriminant.apply(coefficients);
            
            System.out.println("\nEquation: " + a + "x² + " + b + "x + " + c + " = 0");
            System.out.println("Discriminant: " + d);
            
            if (d >= 0) {
                System.out.println("Root 1: " + root1.apply(coefficients));
                System.out.println("Root 2: " + root2.apply(coefficients));
            } else {
                System.out.println("No real roots (complex roots exist)");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Please enter valid numbers!");
        } finally {
            input.close();
        }
    }
}