public class ProdutoIndisponivelException extends EcommerceException {
    public ProdutoIndisponivelException(String produto) {
        super("Produto indisponível: " + produto);
    }
}
