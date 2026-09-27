public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
        if (preco < 0) {
            throw new QuantidadeInvalidaException("Preço inválido: " + preco);
        }
        if (quantidade < 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida: " + quantidade);
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format("%s - R$%.2f - %d unidade(s)", nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException("Estoque insuficiente de " + nome
                    + ": pediu " + quantidadeDesejada + ", disponível " + quantidade);
        }
        quantidade -= quantidadeDesejada;
    }

    // Sobrecarga (polimorfismo estático): desconto simples
    public void aplicarDesconto(double percentual) {
        preco -= preco * percentual / 100;
    }

    // Sobrecarga: desconto limitado a um teto
    public void aplicarDesconto(double percentual, double descontoMaximo) {
        aplicarDesconto(Math.min(percentual, descontoMaximo));
    }
}
