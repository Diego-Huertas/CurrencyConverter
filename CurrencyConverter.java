import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display supported currencies
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Supported currencies: USD, EUR, GBP, JPY");
        System.out.println();

        // Get user input
        System.out.print("Enter the currency you want to convert from (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency you want to convert to (e.g., EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform conversion
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);

        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, toCurrency);
        } else {
            System.out.println("Invalid currency code or unsupported conversion.");
        }

        scanner.close();
    }

    /**
     * Converts an amount from one currency to another based on predefined rates.
     *
     * @param fromCurrency The currency to convert from.
     * @param toCurrency   The currency to convert to.
     * @param amount       The amount to convert.
     * @return The converted amount, or -1 if the conversion is not supported.
     */
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Exchange rates (base currency: USD)
        double usdToEur = 0.92;
        double usdToGbp = 0.73;
        double usdToJpy = 131.5;

        // Conversion logic
        if (fromCurrency.equals("USD")) {
            switch (toCurrency) {
                case "EUR":
                    return amount * usdToEur;
                case "GBP":
                    return amount * usdToGbp;
                case "JPY":
                    return amount * usdToJpy;
            }
        } else if (fromCurrency.equals("EUR")) {
            switch (toCurrency) {
                case "USD":
                    return amount / usdToEur;
                case "GBP":
                    return amount * (usdToGbp / usdToEur);
                case "JPY":
                    return amount * (usdToJpy / usdToEur);
            }
        } else if (fromCurrency.equals("GBP")) {
            switch (toCurrency) {
                case "USD":
                    return amount / usdToGbp;
                case "EUR":
                    return amount * (usdToEur / usdToGbp);
                case "JPY":
                    return amount * (usdToJpy / usdToGbp);
            }
        } else if (fromCurrency.equals("JPY")) {
            switch (toCurrency) {
                case "USD":
                    return amount / usdToJpy;
                case "EUR":
                    return amount * (usdToEur / usdToJpy);
                case "GBP":
                    return amount * (usdToGbp / usdToJpy);
            }
        }

        // Return -1 for unsupported conversions
        return -1;
    }
}
