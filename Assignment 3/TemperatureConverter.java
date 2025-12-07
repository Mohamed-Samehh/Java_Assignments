import java.util.function.Function;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Define Function to convert Celsius to Fahrenheit
        Function<Double, Double> celsiusToFahrenheit = c -> (c * 9 / 5) + 32;
        
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit.apply(celsius);
        
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
    }
}