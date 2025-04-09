package Src.edu.ucc.co.Maria;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

// Interfaz común para archivos y carpetas
interface ArchivoComponent {
    void mostrar(); // Método para mostrar archivo o carpeta
}

// Clase Archivo
class Archivo implements ArchivoComponent {
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar() {
        System.out.println("Archivo: " + nombre);
    }
}

// Clase Carpeta que contiene otros archivos o carpetas
class Carpeta implements ArchivoComponent {
    private String nombre;
    private List<ArchivoComponent> elementos = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar archivos o carpetas a la carpeta
    public void agregar(ArchivoComponent componente) {
        elementos.add(componente);
    }

    @Override
    public void mostrar() {
        System.out.println("Carpeta: " + nombre);
        for (ArchivoComponent c : elementos) {
            c.mostrar(); // Llamada recursiva para mostrar los elementos de la carpeta
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
        System.out.println("   Como administrador de servidores, necesito representar carpetas y archivos");
        System.out.println("   en una estructura jerárquica para recorrer y gestionar todo el sistema de almacenamiento");
        System.out.println("   de forma uniforme.");
        System.out.println("============================");
    }

    // Método para obtener identidad codificada en Base64
    public static String getIdentidad() {
        String identidad = "Sistema de Gestión de Archivos - Composite";
        return Base64.getEncoder().encodeToString(identidad.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Composite";
    }

    public static void main(String[] args) {
        // Mostrar encabezado con la información
        mostrarEncabezado();

        // Crear archivos individuales
        Archivo archivo1 = new Archivo("documento1.txt");
        Archivo archivo2 = new Archivo("documento2.pdf");
        Archivo archivo3 = new Archivo("imagen1.png");

        // Crear carpetas
        Carpeta carpeta1 = new Carpeta("Carpeta1");
        Carpeta carpeta2 = new Carpeta("Carpeta2");

        // Agregar archivos a las carpetas
        carpeta1.agregar(archivo1);
        carpeta1.agregar(archivo2);
        carpeta2.agregar(archivo3);

        // Crear una carpeta principal que contiene otras carpetas
        Carpeta carpetaPrincipal = new Carpeta("CarpetaPrincipal");
        carpetaPrincipal.agregar(carpeta1);
        carpetaPrincipal.agregar(carpeta2);

        // Mostrar la estructura completa
        System.out.println("Estructura de Archivos y Carpetas:");
        carpetaPrincipal.mostrar();

        // Mostrar la identidad y el patrón implementado
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }
}
