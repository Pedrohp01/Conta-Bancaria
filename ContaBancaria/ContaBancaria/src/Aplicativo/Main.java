package Aplicativo;

import java.util.Scanner;
import model.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> banco.listarContas();
                case 6 -> simularRendimentoMensal();
                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU BANCÁRIO ===");
        System.out.println("1. Criar conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Transferir");
        System.out.println("5. Listar contas");
         System.out.println("6- Simular rendimento");
        System.out.println("0. Sair");
    }

    private static void criarConta() {
        System.out.println("Digite o tipo de conta que você quer fazer");
        String tipo = scanner.nextLine();
        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();
        Conta novaConta = banco.criarConta(titular, tipo);
        System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumero());
    }

    private static void depositar() {
        Conta conta = buscarConta("Número da conta: ");
        if (conta != null) {
            double valor = lerDouble("Valor a depositar: ");
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        }
    }

    private static void sacar() {
        Conta conta = buscarConta("Número da conta: ");
        if (conta != null) {
            double valor = lerDouble("Valor a sacar: ");
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
    }

    private static void transferir() {
        Conta origem = buscarConta("Conta origem: ");
        Conta destino = buscarConta("Conta destino: ");
        if (origem != null && destino != null) {
            double valor = lerDouble("Valor a transferir: ");
            if (origem.transferir(destino, valor)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Transferência falhou. Verifique o saldo.");
            }
        }
    }

    private static Conta buscarConta(String mensagem) {
        System.out.print(mensagem);
        String numero = scanner.nextLine();
        Conta conta = banco.buscarConta(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
        }
        return conta;
    }
    private static void simularRendimentoMensal() {
    Conta conta = buscarConta("Número da conta para simular rendimento: ");
    if (conta != null) {
        double rendimento = conta.simularRendimentoMensal();
        System.out.printf("Com 0,5%% de rendimento, essa conta renderia R$ %.2f em 1 mês.%n", rendimento);
    }
}


    private static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer
        return valor;
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um valor válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // limpar o buffer
        return valor;
    }
}
