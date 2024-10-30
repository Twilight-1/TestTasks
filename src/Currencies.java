import java.util.Scanner;
public class Currencies {
    // Фиксированные обменные курсы относительно USD
    static final double USD_TO_EUR = 0.85;
    static final double USD_TO_GBP = 0.75;
    static final double USD_TO_INR = 75.0;
    static final double USD_TO_JPY = 110.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Выберите номер валюты:");
        System.out.println("1. USD (Доллар США)");
        System.out.println("2. EUR (Евро)");
        System.out.println("3. GBP (Фунт стерлингов)");
        System.out.println("4. INR (Индийская рупия)");
        System.out.println("5. JPY (Японская иена)");


        System.out.print("Введите номер валюты, в которой вы хотите ввести сумму: ");
        int fromCurrency = scanner.nextInt();

        System.out.print("Введите номер валюты, в которую вы хотите конвертировать сумму: ");
        int toCurrency = scanner.nextInt();

        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();

        // Конвертация валют
        double amountInUSD = convertToUSD(fromCurrency, amount);
        double convertedAmount = convertFromUSD(toCurrency, amountInUSD);

        System.out.println("Конвертированная сумма: " + convertedAmount);
    }

    static double convertToUSD(int currency, double amount) {
        switch (currency) {
            case 2: // EUR to USD
                return amount / USD_TO_EUR;
            case 3: // GBP to USD
                return amount / USD_TO_GBP;
            case 4: // INR to USD
                return amount / USD_TO_INR;
            case 5: // JPY to USD
                return amount / USD_TO_JPY;
            case 1: // USD to USD
            default:
                return amount;
        }
    }

    static double convertFromUSD(int currency, double amount) {
        switch (currency) {
            case 2: // USD to EUR
                return amount * USD_TO_EUR;
            case 3: // USD to GBP
                return amount * USD_TO_GBP;
            case 4: // USD to INR
                return amount * USD_TO_INR;
            case 5: // USD to JPY
                return amount * USD_TO_JPY;
            case 1: // USD to USD
            default:
                return amount;
        }
    }


}
