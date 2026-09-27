# Sistema de Estoque de Produtos

Java: classes abstratas, herança, interfaces, polimorfismo, composição e exceções.

## Estrutura
- `EstoqueException` (base), `QuantidadeInvalidaException`, `ProdutoIndisponivelException`
- `Vendavel` (interface) implementada por `Product` (abstrata)
- `ProdutoComum` e `ProdutoPerecivel` (20% de desconto se `diasParaVencer <= 3`)
- `Estoque` (composição: tem uma lista de `Product`)
- `EstoqueApp` (`main`)

## Executar
```
javac *.java
java EstoqueApp
```

## Saída
```
=== Produtos cadastrados ===
[0] Caderno - R$15,00 - 20 unidade(s)
[1] Caneta - R$3,50 - 100 unidade(s)
[2] Leite - R$6,00 - 30 unidade(s) - vence em 2 dia(s)
[3] Queijo - R$40,00 - 10 unidade(s) - vence em 15 dia(s)
Valor total do estoque: R$1194,00

=== Cadastro com quantidade negativa ===
Capturada QuantidadeInvalidaException: Quantidade inválida: -5

=== Venda válida ===
Vendidas 5 unidades de Caderno.

=== Venda acima do estoque ===
Capturada ProdutoIndisponivelException: Estoque insuficiente de Caderno: pediu 999, disponível 15

=== Estoque final ===
[0] Caderno - R$15,00 - 15 unidade(s)
[1] Caneta - R$3,50 - 100 unidade(s)
[2] Leite - R$6,00 - 30 unidade(s) - vence em 2 dia(s)
[3] Queijo - R$40,00 - 10 unidade(s) - vence em 15 dia(s)
Valor total do estoque: R$1119,00
```
