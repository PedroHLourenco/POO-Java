package com.mycompany.provapratica;

public class ContaSalario extends ContaBancaria {

    public ContaSalario(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void pagar(double valor) {
        if (getSaldo() >= valor) {
            super.depositar(-valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
}
