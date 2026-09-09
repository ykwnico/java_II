# Sistema de Pedidos e Entregas - VendeMais

Sistema desenvolvido para gerenciar modalidades de frete e prazos de entrega de uma rede varejista, utilizando princípios avançados de Orientação a Objetos para eliminar blocos condicionais (`if/else`) e garantir alta escalabilidade.

## Regras de Cada Modalidade

* **Entrega Normal:** Aplica uma taxa fixa de 10% sobre o valor dos produtos. O prazo estabelecido é de 7 dias.
* **Entrega Expressa:** Aplica uma taxa de 20% sobre o valor dos produtos para prioridade no envio. O prazo fixo é de 2 dias.
* **Retirada na Loja:** Modalidade isenta de frete (R$ 0,00). O prazo fixo para separação é de 1 dia.
* **Entrega Agendada:** Permite ao cliente escolher uma data específica via `LocalDate`. O construtor realiza uma validação preventiva que impede e lança uma exceção caso a data escolhida seja anterior ao dia atual. O prazo em dias é calculado dinamicamente com base na diferença temporal.

## Cálculo do Valor Total

A classe `Pedido` atua como o núcleo de cálculo. O método `valorTotal()` processa a soma matemática entre o atributo `valorProduto` e o resultado obtido de forma polimórfica pelo método `calcularFrete()` injetado na modalidade.

## Comparação das Entregas

Tabela demonstrativa com base na execução do sistema:

| Modalidade | Valor dos produtos | Frete | Total | Prazo |
| :--- | :--- | :--- | :--- | :--- |
| Normal | R$ 129,99 | Conforme regra (10%) | Produto + Frete | 7 dias |
| Expressa | R$ 240,50 | Conforme regra (20%) | Produto + Frete | 2 dias |
| Retirada | R$ 100,00 | R$ 0,00 | R$ 100,00 | 1 dia |
| Agendada | R$ 245,00 | Conforme regra (20%) | Produto + Frete | Data escolhida |

## Composição entre Pedido e Entrega

A arquitetura do projeto utiliza **Composição**. A classe `Pedido` não herda de `Entrega`, mas possui uma referência privada a ela (`private final Entrega modalidade`). Isso permite que a responsabilidade do cálculo seja delegada diretamente para la classe da modalidade correspondente, isolando as regras de negócio de forma limpa.

## Pilares da Orientação a Objetos Aplicados

* **Abstração:** Declarada na classe `Entrega`, definindo os contratos obrigatórios `calcularFrete(double valorProduto)` e `calcularPrazo()`.
* **Herança:** Aplicada nas classes filhas (`EntregaNormal`, `EntregaExpressa`, `RetiradaNaLoja` e `EntregaAgendada`), que estendem a classe mãe e implementam suas respectivas regras de negócio através da anotação `@Override`.
* **Encapsulamento:** Utilização de modificadores de acesso restritos (`private`, `final`) e controle automatizado de identificadores por meio de um contador estático (`contadorID`).

## Instruções para Execução

1. Certifique-se de que todos os arquivos estejam alocados dentro do pacote `atividade_II`.
2. Compile e execute o método `main` presente na classe `Main.java`.
3. O console exibirá a representação textual formatada (`toString`) de cada pedido gerado automaticamente pelo sistema.
