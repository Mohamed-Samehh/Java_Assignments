import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Get first complex number
            System.out.print("Enter real part of first complex number: ");
            double real1 = scanner.nextDouble();
            System.out.print("Enter imaginary part of first complex number: ");
            double imaginary1 = scanner.nextDouble();
            
            // Get second complex number
            System.out.print("Enter real part of second complex number: ");
            double real2 = scanner.nextDouble();
            System.out.print("Enter imaginary part of second complex number: ");
            double imaginary2 = scanner.nextDouble();
            
            // Create two complex numbers
            Complex c1 = new Complex(real1, imaginary1);
            Complex c2 = new Complex(real2, imaginary2);

            System.out.println("Complex Number 1: " + c1);
            System.out.println("Complex Number 2: " + c2);
            System.out.println("-----------------------------");

            // Perform operations
            System.out.println("Addition:       " + c1.add(c2));
            System.out.println("Subtraction:    " + c1.subtract(c2));
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}