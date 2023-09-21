package projetolivro;

public class ProjetoLivro {

    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];
        
        p[0] = new Pessoa("Pedro", 20, "M");
        p[1] = new Pessoa("Duda", 20, "F");
        
        l[0] = new Livro("POO", "Zé da Silva", 450, p[0]);
        l[1] = new Livro("Java POO", "Maria das Dores", 765, p[1]);
        l[2] = new Livro("Aprendendo POO", "Marcos Souza", 312, p[0]);
        
        l[0].abrir();
        l[0].folhear(150);
        
        System.out.println(l[0].detalhes());
    }
    
}
