package model;
import java.util.*;

public class Conta {
    Scanner scan = new Scanner(System.in);

    private String numero;
    private String titular;
    private double saldo;

    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            System.out.println("Saldo em conta: " + saldo + ", saldo após o saque: " + (saldo - valor)
                    + ". Deseja realizar essa operação (Sim || Não)?");
            String resposta = scan.next().toUpperCase();
            if (resposta.equals("SIM")) {
                saldo -= valor;
                System.out.println("Operação realizada. Novo saldo: " + saldo);
                return true;
            } else {
                System.out.println("Operação cancelada");
            }
        } else {
            System.out.println("Valor inválido ou saldo insuficiente.");
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta \n" +
               "  numero: " + numero + "\n" +
               "  titular: " + titular + "\n" +
               "  saldo: " + saldo + "\n";
    }
}
