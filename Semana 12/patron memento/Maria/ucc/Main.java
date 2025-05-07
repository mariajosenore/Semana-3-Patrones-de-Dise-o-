package Maria.ucc;

import java.util.Stack;
import java.util.Base64;

// Originador
class EditorTexto {
    private String contenido = "";

    public void escribir(String texto) {
        contenido += texto;
    }

    public String getContenido() {
        return contenido;
    }

    public Memento guardar() {
        return new Memento(contenido);
    }

    public void restaurar(Memento memento) {
        this.contenido = memento.getEstado();
    }

    // Memento interno
    public static class Memento {
        private final String estado;

        private Memento(String estado) {
            this.estado = estado;
        }

        private String getEstado() {
            return estado;
        }
    }
}

// Caretaker
class Historial {
    private Stack<EditorTexto.Memento> pila = new Stack<>();

    public void guardar(EditorTexto.Memento m) {
        pila.push(m);
    }

    public EditorTexto.Memento deshacer() {
        if (!pila.isEmpty()) {
            return pila.pop();
        }
        return null;
    }
}

// Clase principal
public class Main {

    public static void main(String[] args) {
        mostrarEncabezado();

        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        editor.escribir("Hola");
        historial.guardar(editor.guardar());

        editor.escribir(" mundo");
        historial.guardar(editor.guardar());

        editor.escribir(" cruel");

        System.out.println("Actual: " + editor.getContenido()); // Hola mundo cruel

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 1: " + editor.getContenido()); // Hola mundo

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 2: " + editor.getContenido()); // Hola

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
        System.out.println("   Contexto: Editor de texto con funcionalidad de deshacer");
        System.out.println("   Daniela trabaja como desarrolladora frontend en una app de edición de notas en línea.");
        System.out.println("   Los usuarios pueden escribir texto, y la app guarda automáticamente cada versión del texto");
        System.out.println("   cada cierto tiempo o antes de una operación destructiva.");
        System.out.println("   En un inicio, Daniela intentó guardar copias completas del objeto en listas manualmente,");
        System.out.println("   pero esto era propenso a errores y difícil de mantener. Para resolverlo de forma limpia,");
        System.out.println("   aplicó el patrón Memento.");
        System.out.println("   Creó una clase EditorTexto que actúa como el Originador, una clase Memento que guarda el estado");
        System.out.println("   del texto, y una clase Historial como Caretaker, que maneja una pila de estados.");
        System.out.println("   Ahora, el editor puede hacer undo() para regresar al último estado sin violar la encapsulación.");
        System.out.println("   La solución es limpia, testable, y fácil de extender para soporte de redo().");
        System.out.println("============================");
    }

    // Método que retorna el nombre completo codificado en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método que indica qué patrón se implementó
    public static String getPatron() {
        return "Patrón Memento";
    }
}
