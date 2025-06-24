package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    // Cria uma nova conta com número aleatório único
    public Conta criarConta(String titular) {
        String numero = gerarNumeroUnico();
        Conta nova = new Conta(numero, titular);
        contas.add(nova);
        return nova;
    }

    // Gera um número de conta único (8 dígitos)
    private String gerarNumeroUnico() {
        String numero;
        do {
            numero = String.valueOf((int)(Math.random() * 90000000) + 10000000);
        } while (buscarConta(numero) != null); // Garantir que o número seja único
        return numero;
    }

    // Busca conta por número
    public Conta buscarConta(String numero) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    // Lista todas as contas
    public void listarContas() {
        for (Conta c : contas) {
            System.out.println(c);
        }
    }
}
