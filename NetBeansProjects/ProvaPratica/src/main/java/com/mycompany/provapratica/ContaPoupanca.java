package com.mycompany.provapratica;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String numeroConta) {
        super(numeroConta);
        depositar(50.0); // Valor mínimo inicial
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
