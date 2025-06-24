package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, String titular) {
        super(numero,titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void renderJuros() {
        saldo *= 1.01; // +1% de rendimento
    }
}


