package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;
public class Herança {

    class Funcionario {
        protected String nome;
        protected float salarioBase;

        public Funcionario(String nome, float salarioBase) {
            this.nome = nome;
            this.salarioBase = salarioBase;
        }

        public float calcularSalario() {
            return salarioBase;
        }

        public void exibirInfo() {
            System.out.println("Nome: " + nome);
            System.out.println("Salário final: R$ " + calcularSalario());
            System.out.println("---------------------------");
        }
    }

    // Subclasse Gerente
    class Gerente extends Funcionario {
        private float bonus;

        public Gerente(String nome, float salarioBase, float bonus) {
            super(nome, salarioBase);
            this.bonus = bonus;
        }

        @Override
        public float calcularSalario() {
            return salarioBase + bonus;
        }
    }

    // Subclasse Desenvolvedor
    class Desenvolvedor extends Funcionario {
        private int horasExtras;

        public Desenvolvedor(String nome, float salarioBase, int horasExtras) {
            super(nome, salarioBase);
            this.horasExtras = horasExtras;
        }

        @Override
        public float calcularSalario() {
            return salarioBase + (horasExtras * 50);
        }
    }

    // Subclasse Estagiario
    class Estagiario extends Funcionario {
        public Estagiario(String nome, float salarioBase) {
            super(nome, salarioBase);
        }

        @Override
        public float calcularSalario() {
            return salarioBase * 0.8f; // 20% de desconto
        }
    }

    // Classe principal
    public class SistemaFuncionariosConsole {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            System.out.println("=== Sistema de Funcionários ===");

            boolean continuar = true;
            while (continuar) {
                System.out.print("\nDigite o nome do funcionário: ");
                String nome = sc.nextLine();

                System.out.print("Digite o salário base: ");
                float salarioBase = sc.nextFloat();
                sc.nextLine(); // consumir a quebra de linha

                System.out.println("Escolha o tipo de funcionário:");
                System.out.println("1 - Gerente");
                System.out.println("2 - Desenvolvedor");
                System.out.println("3 - Estagiário");
                System.out.print("Opção: ");
                int tipo = sc.nextInt();
                sc.nextLine();

            }
        }
    }
}
