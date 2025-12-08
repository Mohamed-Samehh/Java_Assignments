import java.util.Scanner;

public class StringUtils {

    // The betterString method
    public static String betterString(String s1, String s2, TwoStringPredicate isBetter) {
        if (isBetter.check(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first string: ");
            String string1 = scanner.nextLine();
            
            System.out.print("Enter second string: ");
            String string2 = scanner.nextLine();

            // Get the longer string
            String longer = betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
            System.out.println("Longer string: " + longer);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}