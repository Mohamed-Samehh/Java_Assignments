public class DisplayMessage {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Java Command Line Application ===");
        System.out.println("This application displays a message to the terminal.");
        System.out.println("Current date/time: " + new java.util.Date());
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
    }
}