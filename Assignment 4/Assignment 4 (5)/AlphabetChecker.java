import java.util.Scanner;

public class AlphabetChecker {
    public static void main(String[] args) {
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            if (input == null || input.isEmpty()) {
                System.out.println("Error: Please enter a non-empty string.");
                return;
            }

            boolean onlyAlphabets = true;
            
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                
                if (!Character.isLetter(ch)) {
                    onlyAlphabets = false;
                    break;
                }
            }

            if (onlyAlphabets) {
                System.out.println("Yes, the string contains only alphabets.");
            } else {
                System.out.println("No, the string contains non-alphabet characters.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Something went wrong - " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}