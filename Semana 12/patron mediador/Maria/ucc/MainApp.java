package Maria.ucc;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

// Interfaz del Mediador
interface TorreControl {
    void enviarMensaje(String mensaje, Participante emisor);
    void registrarParticipante(Participante p);
}

// Participantes abstractos
abstract class Participante {
    protected TorreControl torre;
    protected String nombre;

    public Participante(String nombre, TorreControl torre) {
        this.nombre = nombre;
        this.torre = torre;
        torre.registrarParticipante(this);
    }

    public abstract void recibir(String mensaje);

    public void enviar(String mensaje) {
        torre.enviarMensaje(mensaje, this);
    }

    public String getNombre() {
        return nombre;
    }
}

// Participante concreto: Avión
class Avion extends Participante {
    public Avion(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Avión " + nombre + " recibe: " + mensaje);
    }
}

// Participante concreto: Controlador
class Controlador extends Participante {
    public Controlador(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Controlador " + nombre + " recibe: " + mensaje);
    }
}

// Participante concreto: Pista
class Pista extends Participante {
    public Pista(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Pista " + nombre + " recibe: " + mensaje);
    }
}

// Mediador concreto
class TorreDeControl implements TorreControl {
    private List<Participante> participantes = new ArrayList<>();

    public void registrarParticipante(Participante p) {
        participantes.add(p);
    }

    public void enviarMensaje(String mensaje, Participante emisor) {
        for (Participante p : participantes) {
            if (p != emisor) {
                p.recibir(mensaje + " (de " + emisor.getNombre() + ")");
            }
        }
    }
}

// Clase principal
public class MainApp {
    public static void main(String[] args) {
        mostrarEncabezado();

        TorreControl torre = new TorreDeControl();

        Participante avion1 = new Avion("LATAM 123", torre);
        Participante controlador = new Controlador("ATC Norte", torre);
        Participante pista = new Pista("Pista A", torre);

        avion1.enviar("Solicito autorización para aterrizar");
        controlador.enviar("Autorizado a aterrizar");
        pista.enviar("Pista lista para aterrizaje");

        // Ejecutar los métodos requeridos
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Sistema de mensajería entre componentes en una torre de control de vuelos.");
        System.out.println("   Clara es ingeniera de software en un sistema de gestión aérea.");
        System.out.println("   Está diseñando un módulo donde aviones, controladores de vuelo y personal de pista deben intercambiar mensajes para coordinar aterrizajes.");
        System.out.println("   Inicialmente, cada clase conocía las otras y se comunicaba directamente, creando una red compleja y propensa a errores.");
        System.out.println("   Cualquier cambio en una clase obligaba a modificar muchas otras.");
        System.out.println("   Clara decide implementar el patrón Mediator.");
        System.out.println("   Define una interfaz TorreControl, que centraliza toda la coordinación.");
        System.out.println("   Los objetos Avion, Controlador y Pista solo se comunican a través del mediador.");
        System.out.println("   Esto permite que nuevos componentes puedan integrarse (como un sistema automático de alertas meteorológicas) sin alterar las clases existentes.");
        System.out.println("   Además, el código es más fácil de probar y mantener.");
        System.out.println("============================");
    }

    // Método que retorna el nombre completo codificado en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método que indica qué patrón se implementó
    public static String getPatron() {
        return Base64.getEncoder().encodeToString("Patrón Mediator".getBytes());
    }
}
