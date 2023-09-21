package projetoyoutube;

public class ProjetoYouTube {

    public static void main(String[] args) {

        Video v[] = new Video[3];
        v[0] = new Video("Aula POO");
        v[1] = new Video("Aula PHP");
        v[2] = new Video("Aula HTML");

        Gafanhoto g[] = new Gafanhoto[2];
        g[0] = new Gafanhoto("José", 30, "M", "Zezinho");
        g[1] = new Gafanhoto("Maria", 21, "F", "Mariazinha");
        
        Visualizacao vis[] = new Visualizacao[5];
        vis[0] = new Visualizacao(g[0], v[2]);
        vis[0].avaliar();
        System.out.println(vis[0].toString());
        
        
        vis[1] = new Visualizacao(g[0], v[1]);
        vis[0].avaliar(87.0f);
        System.out.println(vis[1].toString());

        /*System.out.println(v[0].toString());
        System.out.println(g[0].toString());*/
    }

}
