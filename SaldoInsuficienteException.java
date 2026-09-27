public class SaldoInsuficienteException extends EcommerceException {
    public SaldoInsuficienteException(double faltando) {
        super("Saldo insuficiente. Faltam R$" + faltando);
    }
}
