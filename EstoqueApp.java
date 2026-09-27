public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try {
            estoque.adicionarProduto(new ProdutoComum("Caderno", 15.0, 20));
            estoque.adicionarProduto(new ProdutoComum("Caneta", 3.5, 100));
            estoque.adicionarProduto(new ProdutoPerecivel("Leite", 6.0, 30, 2));   // <= 3 dias: 20% off
            estoque.adicionarProduto(new ProdutoPerecivel("Queijo", 40.0, 10, 15));
        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        System.out.println("=== Produtos cadastrados ===");
        estoque.listarProdutos();
        System.out.printf("Valor total do estoque: R$%.2f%n", estoque.calcularValorTotalEstoque());

        // Exceção 1: quantidade negativa no cadastro
        System.out.println("\n=== Cadastro com quantidade negativa ===");
        try {
            estoque.adicionarProduto(new ProdutoComum("Borracha", 2.0, -5));
        } catch (QuantidadeInvalidaException e) {
            System.out.println("Capturada QuantidadeInvalidaException: " + e.getMessage());
        }
        // Ordem dos catches: se o mesmo try pudesse lançar as duas exceções, o catch de
        // EstoqueException (genérico) teria que vir por último; antes dos específicos,
        // eles ficariam inalcançáveis (erro de compilação: "already been caught").

        // Venda válida
        System.out.println("\n=== Venda válida ===");
        try {
            estoque.venderProduto(0, 5);
            System.out.println("Vendidas 5 unidades de Caderno.");
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Capturada ProdutoIndisponivelException: " + e.getMessage());
        }

        // Exceção 2: venda maior que o estoque
        System.out.println("\n=== Venda acima do estoque ===");
        try {
            estoque.venderProduto(0, 999);
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Capturada ProdutoIndisponivelException: " + e.getMessage());
        }

        System.out.println("\n=== Estoque final ===");
        estoque.listarProdutos();
        System.out.printf("Valor total do estoque: R$%.2f%n", estoque.calcularValorTotalEstoque());
    }
}
