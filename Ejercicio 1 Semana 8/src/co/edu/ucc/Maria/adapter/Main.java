package src.co.edu.ucc.Maria.adapter;

import java.util.Base64;

// Interfaz esperada
interface ProcesadorPago {
    void pagar(double monto);
}

// Clase existente de terceros
class SistemaExternoPago {
    public void realizarPago(double cantidad) {
        System.out.println("Pago realizado por: $" + cantidad);
    }
}

// Adapter
class AdaptadorPago implements ProcesadorPago {
    private SistemaExternoPago sistema;

    public AdaptadorPago(SistemaExternoPago sistema) {
        this.sistema = sistema;
    }

    public void pagar(double monto) {
        sistema.realizarPago(monto);
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        ProcesadorPago pago = new AdaptadorPago(new SistemaExternoPago());
        pago.pagar(150.0);
    }

    public static void mostrarEncabezado() {
        System.out.println("\uD83D\uDE80============================\uD83D\uDE80");
        System.out.println("\uD83D\uDC69‍\uD83D\uDCBB Nombre: María José");
        System.out.println("\uD83C\uDFEB Universidad: Universidad Cooperativa de Colombia");
        System.out.println("\uD83D\uDCCD Campus: Cali");
        System.out.println("\uD83D\uDCC2 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("\uD83D\uDCDC Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("\uD83D\uDE80============================\uD83D\uDE80");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("\uD83D\uDE80============================\uD83D\uDE80");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Adapter";
    }
}
