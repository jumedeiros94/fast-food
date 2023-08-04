package org.example.view;

import org.example.model.PedidoItem;
import org.example.service.PedidoService;

import java.util.Scanner;

public class TotemAutoAtendimento {

    private static PedidoService pedidoService = new PedidoService();
    private static Scanner scanner = new Scanner(System.in);

    public void iniciarAtendimento() {
        exibirMenuInicial();
    }

    private static void exibirMenuInicial() {
        System.out.println("==== Menu Inicial ====");
        System.out.println("1. Lanche");
        System.out.println("2. Bebida");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
                exibirMenuLanches();
                break;
            case 2:
                exibirMenuBebidas();
                break;
            default:
                System.out.println("Opção inválida, tente novamente.\n");
                exibirMenuInicial();
        }
    }

    private static void exibirMenuLanches() {
        System.out.println("\n==== Menu Lanches ====");
        System.out.println("1. X-burger - R$ 10,00");
        System.out.println("2. X-salada - R$ 12,00");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
                adicionarItemAoPedido(1, "X-burger", 10.00);
                break;
            case 2:
                adicionarItemAoPedido(2, "X-salada", 12.00);
                break;
            default:
                System.out.println("Opção inválida, tente novamente.\n");
                exibirMenuLanches();
        }
    }

    private static void exibirMenuBebidas() {
        System.out.println("\n==== Menu Bebidas ====");
        System.out.println("1. Refrigerante - R$ 8,00");
        System.out.println("2. Suco - R$ 6,00");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
                adicionarItemAoPedido(3, "Refrigerante", 8.00);
                break;
            case 2:
                adicionarItemAoPedido(4, "Suco", 6.00);
                break;
            default:
                System.out.println("Opção inválida, tente novamente.\n");
                exibirMenuBebidas();
        }
    }

    private static void adicionarItemAoPedido(int codigo, String nome, double valor) {
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = lerInteiro();
        pedidoService.adicionarItem(new PedidoItem(codigo, nome, valor, quantidade));
        exibirCarrinho();
    }

    private static void exibirCarrinho() {
        System.out.println("\n==== Carrinho de Compras ====");
        for (PedidoItem item : pedidoService.getItens()) {
            System.out.printf("%d - %s (R$ %.2f) - Quantidade: %d - Valor Total: R$ %.2f%n",
                    item.getCodigo(), item.getNome(), item.getValor(), item.getQuantidade(), item.getValorTotal());
        }
        System.out.println("Valor Total do Pedido: R$ " + pedidoService.getValorTotal());

        exibirOpcoesCarrinho();
    }

    private static void exibirOpcoesCarrinho() {
        System.out.println("\n==== Opções do Carrinho ====");
        System.out.println("1. Comprar mais itens");
        System.out.println("2. Editar um item");
        System.out.println("3. Remover item");
        System.out.println("4. Finalizar o pedido");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
                exibirMenuInicial();
                break;
            case 2:
                editarItem();
                break;
            case 3:
                removerItem();
                break;
            case 4:
                finalizarPedido();
                break;
            default:
                System.out.println("Opção inválida, tente novamente.\n");
                exibirOpcoesCarrinho();
        }
    }

    private static void editarItem() {
        System.out.print("Digite o código do produto que deseja editar: ");
        int codigo = lerInteiro();

        PedidoItem item = buscarItemNoPedido(codigo);

        if (item != null) {
            System.out.print("Digite a nova quantidade desejada: ");
            int novaQuantidade = lerInteiro();
            pedidoService.atualizarQuantidade(codigo, novaQuantidade);
            exibirCarrinho();
        } else {
            System.out.println("Código do produto inválido.\n");
            editarItem();
        }
    }

    private static void removerItem() {
        System.out.print("Digite o código do produto que deseja remover: ");
        int codigo = lerInteiro();

        PedidoItem item = buscarItemNoPedido(codigo);

        if (item != null) {
            pedidoService.removerItem(codigo);
            exibirCarrinho();
        } else {
            System.out.println("Código do produto inválido.\n");
            removerItem();
        }
    }

    private static PedidoItem buscarItemNoPedido(int codigo) {
        for (PedidoItem item : pedidoService.getItens()) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    private static void finalizarPedido() {
        System.out.println("\nValor Total do Pedido: R$ " + pedidoService.getValorTotal());
        System.out.println("Itens Selecionados:");

        for (PedidoItem item : pedidoService.getItens()) {
            System.out.printf("%s (Quantidade: %d)%n", item.getNome(), item.getQuantidade());
        }

        System.out.println("\nFormas de pagamento disponíveis:");
        System.out.println("1. Cartão de crédito");
        System.out.println("2. Cartão de débito");
        System.out.println("3. Vale refeição");
        System.out.println("4. Dinheiro");
        System.out.print("Escolha uma opção de pagamento: ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1:
            case 2:
            case 3:
                System.out.println("Compra finalizada com sucesso! Boa refeição.");
                break;
            case 4:
                efetuarPagamentoEmDinheiro();
                break;
            default:
                System.out.println("Opção inválida, tente novamente.\n");
                finalizarPedido();
        }
    }

    private static void efetuarPagamentoEmDinheiro() {
        System.out.print("Digite o valor em dinheiro que irá pagar: R$ ");
        double valorPago = lerDouble();

        if (valorPago >= pedidoService.getValorTotal()) {
            double troco = valorPago - pedidoService.getValorTotal();
            System.out.println("Compra finalizada com sucesso! Troco: R$ " + troco);
        } else {
            System.out.println("Valor insuficiente, tente novamente.\n");
            efetuarPagamentoEmDinheiro();
        }
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Formato inválido, para escolher o item, você deve informar o número dele: ");
        }
        int inteiro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        return inteiro;
    }

    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.print("Formato inválido, digite um valor numérico: R$ ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        return valor;
    }
}
