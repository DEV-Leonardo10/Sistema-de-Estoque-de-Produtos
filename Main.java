public class Main {
    public static void main(String[] args) {
        Product notebook = new Product("Notebook", 3500.0, 5);
        Product mouse = new Product("Mouse", 80.0, 0); // sem estoque
        ShoppingCart cart = new ShoppingCart();

        // 1) ProdutoIndisponivelException, capturada pelo tipo BASE (pegadinha)
        try {
            cart.addItem(mouse);
        } catch (EcommerceException e) {
            System.out.println("Erro 1: " + e.getMessage());
        }

        // 2) SaldoInsuficienteException, com catches específicos (desafio extra)
        try {
            cart.addItem(notebook);
            cart.checkout(1000.0);
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Erro 2 (estoque): " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro 2 (saldo): " + e.getMessage());
        } catch (EcommerceException e) { // genérico por último
            System.out.println("Erro genérico: " + e.getMessage());
        }

        // ERRO DE COMPILAÇÃO: com o catch genérico ANTES dos específicos,
        // os específicos ficam inalcançáveis (o genérico já captura os subtipos):
        //
        // try {
        //     cart.checkout(1000.0);
        // } catch (EcommerceException e) {
        //     System.out.println("Erro genérico: " + e.getMessage());
        // } catch (ProdutoIndisponivelException e) { // error: exception ProdutoIndisponivelException has already been caught
        //     System.out.println("Erro (estoque): " + e.getMessage());
        // } catch (SaldoInsuficienteException e) {   // error: exception SaldoInsuficienteException has already been caught
        //     System.out.println("Erro (saldo): " + e.getMessage());
        // }
    }
}
