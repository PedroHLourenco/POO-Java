package Atividade01;

class TransporteTerrestre extends Transportadora {
    private String tipoVeiculo;

    public TransporteTerrestre(String nome, String endereco, double taxaEntrega, String tipoVeiculo) {
        super(nome, endereco, taxaEntrega);
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public double calculaFrete(int altura, int largura) {
        return 0.2 * (altura / largura);
    }

}