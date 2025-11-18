package com.example.myapplication;

import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Valor total no estoque
    public double valorTotalEstoque() {
        return preco * quantidade;
    }

    // Entrada de produtos no estoque
    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    // Saída de produtos do estoque
    public void removerEstoque(int quantidade) {
        if (quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente no estoque!");
        }
    }

    // Mostrar dados do produto
    public void mostrarDados() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade no estoque: " + quantidade);
        System.out.println("Valor total no estoque: R$ " + valorTotalEstoque());
        System.out.println("---------------------------");
    }
}

class EstoqueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Digite o preço: ");
        double preco = sc.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantidade = sc.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);

        System.out.println("\n=== Dados do Produto ===");
        produto.mostrarDados();

        sc.close();
    }
}

