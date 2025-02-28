
package co.edu.ucc.Maria_;

import java.util.Scanner;

import src.co.edu.ucc.Maria_.Sistema_de_Vehiculos.Logger;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado(); // Mostrar el encabezado al inicio
        Scanner scanner = new Scanner(System.in);
        Logger.log("Bienvenido al sistema de vehículos.");

        try {
            Logger.log("Ingrese el tipo de vehículo (electrico/gasolina): ");
            String tipo = scanner.nextLine();

            Logger.log("Ingrese la marca: ");
            String marca = scanner.nextLine();

            Logger.log("Ingrese el modelo: ");
            String modelo = scanner.nextLine();

            Logger.log("Ingrese el año: ");
            int año = scanner.nextInt();

            final Vehiculo vehiculo = VehiculoFactory.crearVehiculo(tipo, marca, modelo, año);
            Logger.log("Vehículo creado: " + vehiculo.toString());

            Logger.log("Encendiendo vehículo...");
            vehiculo.encender();

            Logger.log("Apagando vehículo...");
            vehiculo.apagar();

        } catch (VehiculoNoValidoException e) {
            Logger.log("Error: " + e.getMessage());
        } catch (Exception e) {
            Logger.log("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            Logger.log("Sistema cerrado.");

            // Ejecutar métodos getIdentidad() y getPatron() al final
            Logger.log("\nInformación adicional:");
            Logger.log("Identidad codificada: " + getIdentidad());
            Logger.log(getPatron());
        }
    }

    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("📜 Historia de usuario:");
        System.out.println("   Como desarrollador,");
        System.out.println("   quiero implementar un sistema de vehículos que utilice el patrón Factory Method");
        System.out.println("   para eliminar la creación manual de objetos,");
        System.out.println("   y además agregar métodos para obtener la identidad del desarrollador y el patrón implementado,");
        System.out.println("   para que el código sea más claro y mantenible.");
        System.out.println("🚀============================🚀");
    }

    // Método para obtener la identidad del desarrollador codificada en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José"; // Cambia esto por tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Patrón implementado: Factory Method";
    }
}