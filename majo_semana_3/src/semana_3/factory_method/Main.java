package semana_3.factory_method;

import java.util.Base64;

public class Main { 
    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/usuario/repo");
        System.out.println("🚀============================🚀");
    }
    
    public static String getIdentidad() {
        String nombreCompleto = "María José"; // Reemplaza con el nombre completo si es diferente
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) { 

        mostrarEncabezado();

        Vehiculo v1 = FabricaVehiculos.crearVehiculo("electrico"); 

        v1.conducir(); 
        
        System.out.println("Identidad codificada: " + getIdentidad());

    } 

} 