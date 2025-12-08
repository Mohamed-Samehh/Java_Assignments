import java.util.Scanner;
import java.util.function.Function;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            // Define Function to convert Celsius to Fahrenheit
            Function<Double, Double> celsiusToFahrenheit = c -> (c * 9 / 5) + 32;
            
            System.out.print("Enter temperature in Celsius: ");
            double celsius = input.nextDouble();
            
            double fahrenheit = celsiusToFahrenheit.apply(celsius);
            
            System.out.println(celsius + "°C = " + fahrenheit + "°F");
            
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number!");
        } finally {
            input.close();
        }
    }
}