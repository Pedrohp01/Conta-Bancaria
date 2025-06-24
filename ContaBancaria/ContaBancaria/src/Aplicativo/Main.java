package Aplicativo;

import java.util.Scanner;


import model.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU BANCÁRIO ===");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Criar nova conta
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();
                    Conta novaConta = banco.criarConta(titular);
                    System.out.println(" Conta criada com sucesso!");
                    System.out.println("Número da conta: " + novaConta.getNumero());
                    break;

                case 2:
                    // Depositar
                    System.out.print("Número da conta: ");
                    String numeroContaDeposito = scanner.nextLine();
                    Conta contaDeposito = banco.buscarConta(numeroContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Valor a depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    // Sacar
                    System.out.print("Número da conta: ");
                    String numeroContaSaque = scanner.nextLine();
                    Conta contaSaque = banco.buscarConta(numeroContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Valor a sacar: ");
                        double valorSaque = scanner.nextDouble();
                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    // Transferir
                    System.out.print("Conta origem: ");
                    String contaOrigem = scanner.nextLine();
                    System.out.print("Conta destino: ");
                    String contaDestino = scanner.nextLine();
                    Conta origem = banco.buscarConta(contaOrigem);
                    Conta destino = banco.buscarConta(contaDestino);
                    if (origem != null && destino != null) {
                        System.out.print("Valor a transferir: ");
                        double valorTransferir = scanner.nextDouble();
                        if (origem.transferir(destino, valorTransferir)) {
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Transferência falhou. Verifique o saldo.");
                        }
                    } else {
                        System.out.println("Uma ou ambas as contas não foram encontradas.");
                    }
                    break;

                case 5:
                    // Listar todas as contas
                    banco.listarContas();
                    break;

                case 0:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
