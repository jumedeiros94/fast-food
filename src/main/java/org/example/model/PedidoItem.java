package org.example.model;

public class PedidoItem {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;

    public PedidoItem(int codigo, String nome, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valor * quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
