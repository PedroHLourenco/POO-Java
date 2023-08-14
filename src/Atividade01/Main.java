package Atividade01;

public class Main {
    public static void main(String[] args) {
        Transportadora transNautico = new TransporteNautico("Transporte Marítimo", "Rua do Porto", 5.0, "Barco");
        double freteNautico = transNautico.calculaFrete(10, 5);
        System.out.println("Frete Transporte Náutico: R$ " + freteNautico);

        Transportadora transTerrestre = new TransporteTerrestre("Transporte Terrestre", "Avenida Principal", 8.0, "Caminhão");
        double freteTerrestre = transTerrestre.calculaFrete(8, 4);
        System.out.println("Frete Transporte Terrestre: R$ " + freteTerrestre);
    }
}