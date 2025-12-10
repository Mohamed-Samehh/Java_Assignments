public class EchoInput {
    public static void main(String[] args) {
        System.out.println("=== Echo Input Application ===");
        
        // Check if any arguments were provided
        if (args.length == 0) {
            System.out.println("Error: No input provided!");
            return;
        }

        String input = args[0];

        System.out.println("Original input: " + input);
        System.out.println("Input length: " + input.length() + " characters");
        System.out.println("Is empty? " + input.isEmpty());
        System.out.println("Is numeric? " + isNumeric(input));
        System.out.println("Uppercase: " + input.toUpperCase());
        System.out.println("Lowercase: " + input.toLowerCase());

        System.out.println("\n=== Echoing back ===");
        System.out.println("You said: \"" + input + "\"");
    }
    
    // Helper method to check if string is numeric
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}