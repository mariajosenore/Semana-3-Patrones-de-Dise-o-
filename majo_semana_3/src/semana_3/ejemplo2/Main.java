package semana_3.ejemplo2;

import java.util.Base64;

// Interfaz para las figuras
interface Figura { 
    void dibujar(); 
}

// Clases concretas de figuras
class Circulo implements Figura { 
    public void dibujar() { 
        System.out.println("Dibujando un círculo"); 
    } 
} 

class Cuadrado implements Figura { 
    public void dibujar() { 
        System.out.println("Dibujando un cuadrado"); 
    } 
} 

// Interfaz para la fábrica de figuras
interface FiguraFactory {
    Figura crearFigura();
}

// Clases concretas de fábricas
class CirculoFactory implements FiguraFactory {
    public Figura crearFigura() {
        return new Circulo();
    }
}

class CuadradoFactory implements FiguraFactory {
    public Figura crearFigura() {
        return new Cuadrado();
    }
}

// Clase principal
public class Main { 
    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("🚀============================🚀");
    }
    
    public static String getIdentidad() {
        String nombreCompleto = "María José"; // Reemplaza con el nombre completo si es diferente
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    
    public static void main(String[] args) { 
        mostrarEncabezado();
        
        // Usamos la fábrica específica para crear las figuras
        FiguraFactory factory = new CirculoFactory(); 
        Figura figura = factory.crearFigura(); 
        figura.dibujar(); 

        System.out.println("Identidad codificada: " + getIdentidad());
    } 
}
