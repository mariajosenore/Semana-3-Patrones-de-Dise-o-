package semana_3.singletons3;

import java.util.Base64;

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
        // Obtiene la única instancia del Logger
        Logger logger = Logger.getInstance();
        
        // Usa el método log para imprimir mensajes
        logger.log("Iniciando la aplicación...");
        logger.log("Ejecutando el patrón Singleton correctamente.");
        System.out.println("Identidad codificada: " + getIdentidad());
    }
}