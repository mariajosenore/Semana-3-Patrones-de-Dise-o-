package semana_3.ejemplo1;

import java.util.Base64;

class Database { 

    private static volatile Database instance;  // Volatile para evitar problemas de caché en hilos

    private Database() { 
        System.out.println("Conectando a la base de datos..."); 
    } 

    public static Database getInstance() { 
        if (instance == null) {  // Primera comprobación
            synchronized (Database.class) { 
                if (instance == null) {  // Segunda comprobación
                    instance = new Database();
                }
            }
        } 
        return instance; 
    } 

    public void ejecutarConsulta(String consulta) { 
        System.out.println("Ejecutando: " + consulta); 
    } 
} 

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
        String nombreCompleto = "María José";  
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static void main(String[] args) { 
        mostrarEncabezado();

        Database db1 = Database.getInstance(); 
        db1.ejecutarConsulta("SELECT * FROM pedidos"); 

        Database db2 = Database.getInstance();
        db2.ejecutarConsulta("SELECT * FROM clientes");

        System.out.println("Identidad codificada: " + getIdentidad());
    } 
}
