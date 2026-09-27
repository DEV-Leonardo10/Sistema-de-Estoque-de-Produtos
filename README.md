# Carrinho de Compras com Tratamento de Exceções

Desafio de POO (herança e exceções) em Java.

## Classes
- `EcommerceException`: exceção base
- `ProdutoIndisponivelException` e `SaldoInsuficienteException`: herdam de `EcommerceException`
- `Product`: nome, preço e estoque (encapsulados)
- `ShoppingCart`: `addItem` e `checkout`, que lançam as exceções
- `Main`: demonstra as duas exceções com try/catch

## Como executar
```
javac *.java
java Main
```

## Resposta do Desafio Extra
O Java escolhe o primeiro `catch` compatível, de cima para baixo. Como `ProdutoIndisponivelException` e `SaldoInsuficienteException` são `EcommerceException`, se o catch genérico vier primeiro ele captura tudo e os específicos ficam inalcançáveis, o que gera erro de compilação ("exception already caught"). Por isso o genérico deve vir por último.
