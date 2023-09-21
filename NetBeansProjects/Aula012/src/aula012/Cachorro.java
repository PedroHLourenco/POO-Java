package aula012;

public class Cachorro extends Mamifero{
    @Override
    public void emitirSom(){
        System.out.println("AU! AU! AU!");
    }
    
    public void abanarRabo(){
        System.out.println("Abanando o rabo");
    }
    
    public void cavarOsso(){
        System.out.println("Cavando osso");
    }
}
