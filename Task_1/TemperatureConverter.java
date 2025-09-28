import java.util.*;

public class TemperatureConverter {
  private static double celsiusToFahrenheit(double c) {
    return (c * 9 / 5) + 32;
  }

  private static double celsiusToKelvin(double c) {
    return c + 273.15;
  }

  private static double fahrenheitToCelsius(double f) {
    return (f - 32) * 5 / 9;
  }

  private static double fahrenheitToKelvin(double f) {
    return (f - 32) * 5 / 9 + 273.15;
  }

  private static double kelvinToCelsius(double k) {
    return k - 273.15;
  }

  private static double kelvinToFahrenheit(double k) {
    return (k - 273.15) * 9 / 5 + 32;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("=== Temperature Converter ===");
    System.out.println("1. Celsius");
    System.out.println("2. Fahrenheit");
    System.out.println("3. Kelvin");
    System.out.println("Enter the scale of your temperature (1/2/3): ");

    int choice = sc.nextInt();
    System.out.print("Enter temperature value: ");
    double temp = sc.nextDouble();

    System.out.println("\nConverted Temperatures:");

    if (choice == 1) {
      System.out.printf("Celsius:    %.2f °C%n", temp);
      System.out.printf("Fahrenheit: %.2f °F%n", celsiusToFahrenheit(temp));
      System.out.printf("Kelvin:     %.2f K%n", celsiusToKelvin(temp));
    } else if (choice == 2) {
      System.out.printf("Fahrenheit: %.2f °F%n", temp);
      System.out.printf("Celsius:    %.2f °C%n", fahrenheitToCelsius(temp));
      System.out.printf("Kelvin:     %.2f K%n", fahrenheitToKelvin(temp));
    } else if (choice == 3) {
      System.out.printf("Kelvin:     %.2f K%n", temp);
      System.out.printf("Celsius:    %.2f °C%n", kelvinToCelsius(temp));
      System.out.printf("Fahrenheit: %.2f °F%n", kelvinToFahrenheit(temp));
    } else {
      System.out.println("Invalid choice. Please run again.");
    }
    sc.close();
  }
}
