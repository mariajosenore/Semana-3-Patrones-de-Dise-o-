package implementacion;

import interfaces.ILetra;

public class LetraConcreta implements ILetra {
    private final char simbolo;
 
    public LetraConcreta(char simbolo) {
        this.simbolo = simbolo;
        System.out.println("Creando letra: " + simbolo);
    }
 
    public void mostrar(String posicion) {
        System.out.println("Letra " + simbolo + " en posición " + posicion);
    }
}
