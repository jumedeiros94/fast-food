# Totem de Auto-atendimento - Sistema de Pedido Autônomo para Lanchonete FastFood

Este repositório contém o código-fonte e a documentação para o sistema de totem de auto-atendimento desenvolvido em Kotlin para modernizar a experiência de compra em uma lanchonete FastFood. O objetivo é permitir que os clientes façam pedidos de forma autônoma, liberando os operadores de caixa para outras funções e agilizando o processo de compra.

## Requisitos

O sistema de totem de auto-atendimento deve atender aos seguintes requisitos:

1. A tela inicial deve apresentar um menu onde o cliente pode selecionar entre comprar um **Lanche** (opção 1) ou uma **Bebida** (opção 2).
2. Caso o cliente insira uma opção inválida, o sistema deve mostrar a mensagem "Opção inválida, tente novamente" e apresentar novamente o menu inicial.
3. O sistema deve aceitar apenas o número da opção (1 para Lanche e 2 para Bebida).
4. Se o cliente inserir um valor não numérico, o sistema deve retornar a mensagem "Formato inválido, para escolher o item, você deve informar o número dele".
5. Ao selecionar Lanche (1), o sistema deve exibir as opções: 1. X-burger e 2. X-salada. Caso o cliente escolha uma opção inválida, a mensagem "Opção inválida, tente novamente" deve ser exibida.
6. O sistema deve permitir ao cliente selecionar a quantidade do lanche desejada. O carrinho de compra deve mostrar o código, quantidade, nome e valor do lanche, bem como o valor total do pedido até aquele momento.
   - X-burger: R$ 10,00
   - X-salada: R$ 12,00
7. Ao selecionar Bebida (2), o sistema deve exibir as opções: 1. Refrigerante e 2. Suco. Caso o cliente escolha uma opção inválida, a mensagem "Opção inválida, tente novamente" deve ser exibida.
8. O sistema deve permitir ao cliente selecionar a quantidade de bebidas desejada. O carrinho de compra deve mostrar o código, quantidade, nome e valor da bebida, bem como o valor total do pedido até aquele momento.
   - Refrigerante: R$ 8,00
   - Suco: R$ 6,00
9. Após selecionar o item e a quantidade, o sistema deve dar ao cliente a opção de incluir mais itens, editar um item, remover um item ou finalizar o pedido.

## Executando o Projeto

1. Clone este repositório.
2. Certifique-se de ter as configurações apropriadas para executar o projeto Kotlin.
3. Execute o sistema de totem de auto-atendimento.

## Contribuição

Contribuições são bem-vindas! Se você encontrar problemas ou tiver sugestões para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.





