package Maria.Ucc.edu.co;

import java.util.Base64;

// Clase Auto
class Auto {
    private String motor;
    private String sistemaAudio;
    private boolean sensoresProximidad;

    public Auto(String motor, String sistemaAudio, boolean sensoresProximidad) {
        this.motor = motor;
        this.sistemaAudio = sistemaAudio;
        this.sensoresProximidad = sensoresProximidad;
    }

    public void mostrarConfiguracion() {
        System.out.println("Motor: " + motor);
        System.out.println("Sistema de Audio: " + sistemaAudio);
        System.out.println("Sensores de Proximidad: " + (sensoresProximidad ?  "Sí" : "No"));
    }

    public static String getIdentidad() {
        String nombreCompleto = "María José Gómez";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "Builder";
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }
}

// Builder de Auto
class AutoBuilder {
    private String motor = "gasolina";
    private String sistemaAudio = "estándar";
    private boolean sensoresProximidad = false;

    public AutoBuilder conMotor(String motor) {
        this.motor = motor;
        return this;
    }

    public AutoBuilder conSistemaAudio(String sistemaAudio) {
        this.sistemaAudio = sistemaAudio;
        return this;
    }

    public AutoBuilder conSensoresProximidad(boolean sensores) {
        this.sensoresProximidad = sensores;
        return this;
    }

    public Auto construir() {
        return new Auto(motor, sistemaAudio, sensoresProximidad);
    }
}

// Clase principal
public class FabricaAutos {
    public static void main(String[] args) {
        System.out.println("PRIME");
        Auto.mostrarEncabezado();

        Auto auto1 = new AutoBuilder()
            .conMotor("eléctrico")
            .conSistemaAudio("premium")
            .conSensoresProximidad(true)
            .construir();

        auto1.mostrarConfiguracion();
    }
}
