package Atividade01;

class TransporteNautico extends Transportadora {
    private String tipoEmbarcacao;

    public TransporteNautico(String nome, String endereco, double taxaEntrega, String tipoEmbarcacao) {
        super(nome, endereco, taxaEntrega);
        this.tipoEmbarcacao = tipoEmbarcacao;
    }

    @Override
    public double calculaFrete(int altura, int largura) {
        return 0.1 * (altura + largura);
    }
}




