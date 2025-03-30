package ucc.Maria;

import java.util.Base64;

interface ReporteNuevo {
    void generar(String datos);
}

class SistemaContableAntiguo {
    public void exportar(String contenido) {
        System.out.println("Exportando a sistema contable antiguo: " + contenido);
    }
}

class AdaptadorReporte implements ReporteNuevo {
    private SistemaContableAntiguo sistema;

    public AdaptadorReporte(SistemaContableAntiguo sistema) {
        this.sistema = sistema;
    }

    public void generar(String datos) {
        sistema.exportar(datos);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        ReporteNuevo reporte = new AdaptadorReporte(new SistemaContableAntiguo());
        reporte.generar("Factura #123 - Total: $50000");
        
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
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
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Adapter";
    }
}
