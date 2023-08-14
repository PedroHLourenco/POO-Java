package Atividade01;

abstract class Transportadora {
    protected String nome;
    protected String endereco;
    protected double txEntrega;

    public Transportadora(String nome, String endereco, double taxaEntrega) {
        this.nome = nome;
        this.endereco = endereco;
        this.txEntrega = taxaEntrega;
    }

    public abstract double calculaFrete(int altura, int largura);

    public void realizarEntrega() {

        System.out.println("Realizando entrega...");
    }
}
