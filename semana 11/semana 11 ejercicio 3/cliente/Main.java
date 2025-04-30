package cliente;

// Removed conflicting imports as FabricaLetras and ILetra are defined in this file.

import java.util.Base64;
import java.util.HashMap;

interface ILetra {
    void mostrar(String posicion);
}

class LetraConcreta implements ILetra {
    private final char simbolo;

    public LetraConcreta(char simbolo) {
        this.simbolo = simbolo;
        System.out.println("Creando letra: " + simbolo);
    }

    public void mostrar(String posicion) {
        System.out.println("Letra " + simbolo + " en posición " + posicion);
    }
}

class FabricaLetras {
    private static final HashMap<Character, ILetra> pool = new HashMap<>();

    public static ILetra obtenerLetra(char simbolo) {
        if (!pool.containsKey(simbolo)) {
            pool.put(simbolo, (ILetra) new LetraConcreta(simbolo));
        }
        return pool.get(simbolo);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();

        ILetra letraA1 = FabricaLetras.obtenerLetra('A');
        ILetra letraA2 = FabricaLetras.obtenerLetra('A');
        ILetra letraB = FabricaLetras.obtenerLetra('B');

        letraA1.mostrar("1");
        letraA2.mostrar("2");
        letraB.mostrar("3");

        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como desarrollador, quiero ahorrar memoria en el editor de texto");
        System.out.println("   reutilizando las mismas letras en diferentes posiciones.");
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Patrón Flyweight";
    }
}
