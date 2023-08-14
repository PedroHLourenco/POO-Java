package Atividade01;

public class Main {
    public static void main(String[] args) {
        Transportadora transporteNautico = new TransporteNautico("Transporte Marítimo", "Rua do Porto", 5.0, "Barco");
        double freteNautico = transporteNautico.calculaFrete(10, 5);
        System.out.println("Frete Transporte Náutico: R$ " + freteNautico);

        Transportadora transporteTerrestre = new TransporteTerrestre("Transporte Terrestre", "Avenida Principal", 8.0, "Caminhão");
        double freteTerrestre = transporteTerrestre.calculaFrete(8, 4);
        System.out.println("Frete Transporte Terrestre: R$ " + freteTerrestre);
    }
}