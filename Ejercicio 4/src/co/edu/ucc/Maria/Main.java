package co.edu.ucc.Maria;
import java.util.Base64;

interface ModoReporte {
    void imprimir(String contenido);
}

class Consola implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Reporte en consola: " + contenido);
    }
}

class ArchivoTexto implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Guardando en archivo: " + contenido);
    }
}

abstract class ReporteVehiculo {
    protected ModoReporte salida;

    public ReporteVehiculo(ModoReporte salida) {
        this.salida = salida;
    }

    public abstract void generar(String estado);
}

class ReporteEstado extends ReporteVehiculo {
    public ReporteEstado(ModoReporte salida) {
        super(salida);
    }

    public void generar(String estado) {
        salida.imprimir("Estado del vehículo: " + estado);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        ReporteVehiculo reporte = new ReporteEstado(new Consola());
        reporte.generar("Motor funcionando, llantas en buen estado");
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

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "bridge";
    }
}
