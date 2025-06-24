package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numero,String titular) {
        super(numero, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + 100) { 
            saldo -= valor;
            return true;
        }
        return false;
    }
}
