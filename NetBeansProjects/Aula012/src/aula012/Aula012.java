package aula012;

public class Aula012 {

    public static void main(String[] args) {
        //Animal n = new Animal(); classe abstrata, não cria objetos
        
        Mamifero m = new Mamifero();
        Reptil r = new Reptil();
        Peixe p = new Peixe();
        Ave a= new Ave();
        Canguru c = new Canguru();
        Cachorro ca = new Cachorro();
        Cobra co = new Cobra();
        Tartaruga t = new Tartaruga();
        Goldfish g = new Goldfish();
        Arara ar = new Arara();
        
        c.locomover();
        ca.locomover();
        c.emitirSom();
        ca.emitirSom();
             
    }

}
