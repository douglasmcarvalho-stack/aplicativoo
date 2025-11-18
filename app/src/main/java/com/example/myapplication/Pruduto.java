package com.example.myapplication;

public class Pruduto {
    private String nome;
    private double preco;
    private int quantidade;

    public Pruduto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    public void adicionarProdutos(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerProdutos(int quantidade) {
        if (quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        }
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                "\nPreço: R$ " + String.format("%.2f", preco) +
                "\nQuantidade: " + quantidade +
                "\nValor total em estoque: R$ " + String.format("%.2f", valorTotalEmEstoque());
    }
}
