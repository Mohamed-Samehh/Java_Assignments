public class PrintMultipleLines {
    public static void main(String[] args) {
        System.out.println("=== Print Multiple Lines Application ===");

        if (args.length < 2) {
            System.out.println("Error: Insufficient arguments!");
            
            if (args.length == 1) {
                System.out.println("\nYou provided only 1 argument: " + args[0]);
            }
            return;
        }
        
        try {
            int count = Integer.parseInt(args[0]);
            String text = args[1];

            if (count < 0) {
                System.out.println("Error: Number must be non-negative!");
                return;
            }
            
            if (count > 100) {
                System.out.println("Warning: Number is large (" + count + "). This might flood your terminal!");
                System.out.println("Operation aborted. Please use a smaller number.");
                return;
            }

            System.out.println("\nPrinting '" + text + "' " + count + " times:\n");
            
            for (int i = 1; i <= count; i++) {
                System.out.println(text);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Error: First argument must be a valid integer!");
            System.out.println("You provided: \"" + args[0] + "\" which is not a number.");
        }
    }
}