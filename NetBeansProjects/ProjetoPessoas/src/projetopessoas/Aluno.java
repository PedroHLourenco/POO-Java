package projetopessoas;

public class Aluno extends Pessoa{
    //Atributos
    private int mat;
    private String curso;
    
    //Métodos
    public void cancelarMat(){
        System.out.println("A Matrícula será cancelada!");
    }

    //Métodos especiais
    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
}
