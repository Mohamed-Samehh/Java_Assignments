import java.util.StringTokenizer;

public class LabExercise {
    public static void main(String[] args) {
        String sentence = "ITI develops people and ITI house of developers and ITI for people";
        String word = "ITI";
        
        // Method 1: Using indexOf
        int count1 = 0;
        int index = 0;
        while ((index = sentence.indexOf(word, index)) != -1) {
            count1++;
            index += word.length();
        }
        System.out.println("Method 1 (indexOf): " + count1);
        
        // Method 2: Using split
        String[] parts = sentence.split(word, -1);
        int count2 = parts.length - 1;
        System.out.println("Method 2 (split): " + count2);
        
        // StringTokenizer
        System.out.println("\nTokenizer output:");
        StringTokenizer tokenizer = new StringTokenizer(sentence, word);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }
        
        // Split IP address
        String ipAddress = "192.168.1.1";
        System.out.println("\nIP Address parts:");
        String[] ipParts = ipAddress.split("\\.");
        for (String part : ipParts) {
            System.out.println(part);
        }
    }
}