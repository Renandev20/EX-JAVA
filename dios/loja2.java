import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface DiscountStrategy {
    double applyDiscount(double total);
}

// Implementacoes concretas do Strategy
class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

class FreeShipping implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        System.out.println("Frete gratis aplicado");
        return total;
    }
}

// Contexto que utiliza a estrategia
class ShoppingCart {
    private List<Double> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(double price) {
        products.add(price);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Double price : products) {
            total += price;
        }
        if (discountStrategy != null) {
            total = discountStrategy.applyDiscount(total);
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instancias das estrategias de desconto
        DiscountStrategy tenPercentDiscount = new TenPercentDiscount();
        DiscountStrategy freeShipping = new FreeShipping();

        // Criando o carrinho de compras
        ShoppingCart cart = new ShoppingCart();

        // Adicionando produtos ao carrinho
        String productName = scanner.nextLine();
        double productPrice = scanner.nextDouble();
        cart.addProduct(productPrice);

        // Escolhendo a estrategia de desconto
        int strategyChoice = scanner.nextInt();

        // Configurando a estrategia no carrinho
        switch (strategyChoice) {
            case 1:
                cart.setDiscountStrategy(tenPercentDiscount);
                break;
            case 2:
                cart.setDiscountStrategy(freeShipping);
                break;
            default:
                System.out.println("Escolha invalida. Nenhum desconto aplicado.");
        }

        // Exibindo o total da compra
        System.out.println("Total da compra: R$" + cart.calculateTotal());
    }
}
