import java.util.Map;
import java.util.Scanner;

public class Currencies {
    // Фиксированные обменные курсы относительно USD
    private static final Map<String, Double> exchangeRates = Map.of(
            "USD", 1.0,
            "EUR", 0.93,
            "GBP", 0.80,
            "JPY", 150.25,
            "RUB", 92.50,
            "INR", 7.18
    );
    // Конвертация валют
    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) return amount;
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }
    // проверяем корректность ввода валюты
    private static String getValidCurrencyInput(Scanner scanner, String promptMessage) {
        String currency;
        while (true) {
            System.out.print(promptMessage);
            currency = scanner.nextLine().trim().toUpperCase();

            if (currency.isEmpty()) {
                System.out.println("Ошибка: Введите код валюты!");
                continue;
            }

            if (!exchangeRates.containsKey(currency)) {
                System.out.println("Ошибка: Валюта '" + currency + "' не найдена!");
                System.out.println("Доступные валюты: " + String.join(", ", exchangeRates.keySet()));
                continue;
            }

            break;
        }
        return currency;
    }
    // Использование:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== КОНВЕРТЕР ВАЛЮТ ===");
        System.out.println("Доступные валюты:");
        System.out.println("USD (Доллар США)");
        System.out.println("EUR (Евро)");
        System.out.println("GBP (Фунт стерлингов)");
        System.out.println("JPY (Японская иена)");
        System.out.println("RUB (Российский Рубль)");
        System.out.println("INR (Индийская рупия)");
        System.out.println("========================");

        // Ввод исходной валюты
        String fromCurrency = getValidCurrencyInput(scanner,
                "Введите код валюты(3 символа), в которой вы хотите ввести сумму: ");
        // Ввод целевой валюты
        String toCurrency = getValidCurrencyInput(scanner,
                "Введите код валюты(3 символа), в которую вы хотите конвертировать сумму: ");

        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        // конвертируем валюты
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        System.out.printf("Конвертированная сумма: %.2f %s = %.2f %s\n",
                amount, fromCurrency, convertedAmount, toCurrency);
        scanner.close();
    }

}


