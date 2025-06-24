package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    // Cria uma nova conta com número aleatório único e tipo especificado
    public Conta criarConta(String titular, String tipo) {
        String numero = gerarNumeroUnico();
        Conta nova;

        if (tipo.equalsIgnoreCase("corrente")) {
            nova = new ContaCorrente(numero, titular);
        } else {
            nova = new ContaPoupanca(numero, titular);
        }

        contas.add(nova);
        return nova;
    }

    // Gera um número de conta único (8 dígitos)
    private String gerarNumeroUnico() {
        String numero;
        do {
            numero = String.valueOf((int)(Math.random() * 90000000) + 10000000);
        } while (buscarConta(numero) != null); // Evita duplicação
        return numero;
    }

    // Busca uma conta pelo número
    public Conta buscarConta(String numero) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    // Lista todas as contas cadastradas
    public void listarContas() {
        for (Conta c : contas) {
            System.out.println(c);
        }
    }

    // Aplica rendimento em todas as contas poupança
    public void aplicarRendimento() {
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca poupanca) {
                poupanca.renderJuros();
            }
        }
    }
}
