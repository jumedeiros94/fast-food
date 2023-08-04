package org.example.service;

import org.example.model.PedidoItem;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<PedidoItem> itens;
    private double valorTotal;

    public PedidoService() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionarItem(PedidoItem item) {
        itens.add(item);
        valorTotal += item.getValorTotal();
    }

    public void removerItem(int codigo) {
        itens.removeIf(item -> item.getCodigo() == codigo);
        atualizarValorTotal();
    }

    public void atualizarQuantidade(int codigo, int novaQuantidade) {
        for (PedidoItem item : itens) {
            if (item.getCodigo() == codigo) {
                item.setQuantidade(novaQuantidade);
                break;
            }
        }
        atualizarValorTotal();
    }

    public void atualizarValorTotal() {
        valorTotal = itens.stream().mapToDouble(PedidoItem::getValorTotal).sum();
    }

}
