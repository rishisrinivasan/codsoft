import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    // Predefined exchange rates (base currency is USD)
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", 1.0);    // USD to USD
        exchangeRates.put("EUR", 0.85);   // USD to EUR
        exchangeRates.put("JPY", 110.0);  // USD to JPY
        exchangeRates.put("GBP", 0.75);   // USD to GBP
        exchangeRates.put("AUD", 1.4);    // USD to AUD
        // Add more currencies and rates as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get base currency from user
        System.out.print("Enter the base currency (e.g., USD, EUR, JPY): ");
        String baseCurrency = scanner.next().toUpperCase();
        
        // Get target currency from user
        System.out.print("Enter the target currency (e.g., USD, EUR, JPY): ");
        String targetCurrency = scanner.next().toUpperCase();
        
        // Check if both currencies are supported
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Unsupported currency entered. Please try again.");
            return;
        }
        
        // Get amount to convert from user
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        
        // Convert the amount
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);
        
        // Display the result
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        
        scanner.close();
    }

    // Method to convert currency
    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseToUSD = amount / exchangeRates.get(baseCurrency);
        return baseToUSD * exchangeRates.get(targetCurrency);
    }
}
