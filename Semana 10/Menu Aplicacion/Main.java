import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

// Interfaz común para opciones de menú y menús
interface ElementoMenu {
    void mostrar(); // Método para mostrar opción o menú
}

// Clase Opcion que representa una opción dentro de un menú
class Opcion implements ElementoMenu {
    private String nombre;

    public Opcion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar() {
        System.out.println("Opción: " + nombre);
    }
}

// Clase Menu que puede contener otras opciones o menús
class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar opciones o submenús al menú
    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrar() {
        System.out.println("Menú: " + nombre);
        for (ElementoMenu e : elementos) {
            e.mostrar(); // Llamada recursiva para mostrar las opciones o submenús
        }
    }
}

// Clase principal
public class Main {
    // Método para mostrar la información de la estructura
    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como diseñador de interfaz, quiero crear menús que puedan tener submenús");
        System.out.println("   y opciones, y que puedan recorrerse uniformemente sin importar su nivel.");
        System.out.println("============================");
    }

    // Método para obtener identidad codificada en Base64
    public static String getIdentidad() {
        String identidad = "Menú de Aplicación Web - Composite";
        return Base64.getEncoder().encodeToString(identidad.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Composite";
    }

    public static void main(String[] args) {
        // Mostrar encabezado con la información
        mostrarEncabezado();

        // Crear opciones de menú
        Opcion opcion1 = new Opcion("Inicio");
        Opcion opcion2 = new Opcion("Configuración");
        Opcion opcion3 = new Opcion("Ayuda");

        // Crear submenú
        Menu subMenu1 = new Menu("Submenú 1");
        Opcion subOpcion1 = new Opcion("Subopción 1.1");
        Opcion subOpcion2 = new Opcion("Subopción 1.2");
        subMenu1.agregar(subOpcion1);
        subMenu1.agregar(subOpcion2);

        // Crear un menú principal
        Menu menuPrincipal = new Menu("Menú Principal");
        menuPrincipal.agregar(opcion1);
        menuPrincipal.agregar(opcion2);
        menuPrincipal.agregar(opcion3);
        menuPrincipal.agregar(subMenu1); // Agregar submenú al menú principal

        // Mostrar el menú completo
        System.out.println("Estructura del Menú:");
        menuPrincipal.mostrar();

        // Mostrar la identidad y el patrón implementado
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }
}
