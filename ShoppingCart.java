import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> produtos = new ArrayList<>();
    private double total = 0;

    public void addItem(Product p) throws ProdutoIndisponivelException {
        if (p.getEstoque() == 0) {
            throw new ProdutoIndisponivelException(p.getNome());
        }
        produtos.add(p);
        total += p.getPreco();
    }

    public void checkout(double saldoDisponivel) throws SaldoInsuficienteException {
        if (total > saldoDisponivel) {
            throw new SaldoInsuficienteException(total - saldoDisponivel);
        }
        System.out.println("Compra finalizada! Total: R$" + total);
    }

    public double getTotal() { return total; }
}
