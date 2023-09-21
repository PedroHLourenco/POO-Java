package ultraemojicombat;

import java.util.Random;

public class Luta {
    //Atributos
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    
    //Métodos
    public void marcarLuta(Lutador l1, Lutador l2){
        if (l1.getCategoria() == l2.getCategoria()) {
            this.aprovada = true;
            this.desafiado = l1;
            this.desafiante = l2;
        } else {
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }
    
    public void lutar(){
        if (this.aprovada) {
            System.out.println("### LUTADOR DESAFIADO ###");
            this.desafiado.apresentar();
            System.out.println("### LUTADOR DESAFIANTE ###");
            this.desafiante.apresentar();
            
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);
            
            System.out.println("=========== RESULTADO DA LUTA ==========");
                    
            switch(vencedor){
                case 0: //empate
                    System.out.println("A luta terminou empatada");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                    break;
                case 1: //vitoria do desafiado
                    System.out.println("O lutador desafiado, " + this.desafiado.getNome() + " venceu a luta!");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                    break;
                case 2: //vitoria do desafiante
                    System.out.println("O lutador desafiante, " + this.desafiante.getNome() + " venceu a luta!");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
            }   
            System.out.println("========================================");
        } else {
            System.out.println("A luta não pode acontecer!");
        }
    }
    
    //Métodos especiais

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
}
