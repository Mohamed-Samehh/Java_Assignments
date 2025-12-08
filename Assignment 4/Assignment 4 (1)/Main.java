import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExceptionThrower tester = new ExceptionThrower();
        
        try {
            // Test Method 1
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            try {
                tester.checkAge(age);
            } catch (MyException e) {
                System.out.println("Caught: " + e.getMessage());
            } finally {
                System.out.println("Age check completed.\n");
            }
            
            // Test Method 2
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            try {
                tester.checkName(name);
            } catch (MyException e) {
                System.out.println("Caught: " + e.getMessage());
            } finally {
                System.out.println("Name check completed.\n");
            }
            
            // Test Method 3
            System.out.print("Enter score: ");
            int score = scanner.nextInt();
            
            try {
                tester.checkScore(score);
            } catch (MyException e) {
                System.out.println("Caught: " + e.getMessage());
            } finally {
                System.out.println("Score check completed.\n");
            }
        } catch (Exception e) {
            System.err.println("Error: Invalid input. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}