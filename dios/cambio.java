import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }

    // Implementação do método de conversão de USD para EUR
    public double convertUSDtoEUR(double amount) {
        // Converter USD para GBP usando a classe antiga
        double gbpAmount = oldConverter.convertUSDtoGBP(amount);

        // Converter GBP para EUR
        return gbpAmount * 1.0625; // Assumindo uma taxa de conversão de 1 GBP para 1.0625 EUR
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        OldCurrencyConverter oldConverter = new OldCurrencyConverter();
        CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

        // Chamar o método para converter USD para EUR
        double resultEUR = adapter.convertUSDtoEUR(input);

        // Imprimir o resultado da conversão
        System.out.println("USD: " + input);
        System.out.println("EUR: " + resultEUR);
    }
}
