package Src.edu.Maria;
import java.util.Base64;

// Interfaz que todas las clases de préstamos deben implementar
interface Prestamo {
    void mostrarDetalles();
}

// Implementación de préstamo hipotecario
class PrestamoHipotecario implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Hipotecario: tasa 5%, plazo 30 años");
    }
}

// Implementación de préstamo automotriz
class PrestamoAutomotriz implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Automotriz: tasa 7%, plazo 5 años");
    }
}

// Implementación de préstamo personal
class PrestamoPersonal implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Personal: tasa 10%, plazo 3 años");
    }
}

// Fábrica para crear los diferentes tipos de préstamo
class FabricaPrestamo {
    public static Prestamo obtenerPrestamo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hipotecario": return new PrestamoHipotecario();
            case "automotriz": return new PrestamoAutomotriz();
            case "personal": return new PrestamoPersonal();
            default: throw new IllegalArgumentException("Tipo de préstamo no válido");
        }
    }
}

// Clase principal para probar la implementación
public class Main {
    
    // Método para obtener la identidad codificada en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";  // Cambia esto por tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método para mostrar el encabezado con la historia de usuario y la identidad
    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("📜 Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("🚀============================🚀");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: Factory");
        System.out.println("🚀============================🚀");
    }

    public static void main(String[] args) {
        // Mostrar encabezado de la historia de usuario y la identidad codificada
        mostrarEncabezado();

        // Solicitar un préstamo hipotecario
        Prestamo prestamoHipotecario = FabricaPrestamo.obtenerPrestamo("hipotecario");
        prestamoHipotecario.mostrarDetalles();

        // Solicitar un préstamo automotriz
        Prestamo prestamoAutomotriz = FabricaPrestamo.obtenerPrestamo("automotriz");
        prestamoAutomotriz.mostrarDetalles();

        // Solicitar un préstamo personal
        Prestamo prestamoPersonal = FabricaPrestamo.obtenerPrestamo("personal");
        prestamoPersonal.mostrarDetalles();
    }
}
