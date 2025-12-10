import java.util.*;

public class SimpleWordDictionary {
    private HashMap<Character, ArrayList<String>> dictionary;

    public SimpleWordDictionary() {
        dictionary = new HashMap<>();
        // Initialize all letters a-z with empty lists
        for (char ch = 'a'; ch <= 'z'; ch++) {
            dictionary.put(ch, new ArrayList<>());
        }
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;

        char firstLetter = Character.toLowerCase(word.charAt(0));
        if (dictionary.containsKey(firstLetter)) {
            dictionary.get(firstLetter).add(word);
            Collections.sort(dictionary.get(firstLetter));
        }
    }

    public void printAll() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            ArrayList<String> words = dictionary.get(ch);
            if (!words.isEmpty()) {
                System.out.println(ch + ": " + words);
            }
        }
    }

    public void printByLetter(char letter) {
        char lowerLetter = Character.toLowerCase(letter);
        if (dictionary.containsKey(lowerLetter)) {
            ArrayList<String> words = dictionary.get(lowerLetter);
            if (words.isEmpty()) {
                System.out.println("No words found for letter '" + letter + "'");
            } else {
                System.out.println(lowerLetter + ": " + words);
            }
        } else {
            System.out.println("Invalid letter: '" + letter + "'");
        }
    }

    public static void main(String[] args) {
        SimpleWordDictionary dict = new SimpleWordDictionary();

        // Add some words
        dict.addWord("Apple");
        dict.addWord("Ant");
        dict.addWord("Banana");
        dict.addWord("Bear");
        dict.addWord("Cat");
        dict.addWord("apple");
        dict.addWord("antelope");

        // Print all words
        System.out.println("All words in dictionary:");
        dict.printAll();
        System.out.println();

        // Print words for specific letter
        System.out.println("Words for letter 'a':");
        dict.printByLetter('a');
        System.out.println();

        System.out.println("Words for letter 'b':");
        dict.printByLetter('b');
        System.out.println();

        // Test empty letter
        System.out.println("Words for letter 'z':");
        dict.printByLetter('z');
    }
}