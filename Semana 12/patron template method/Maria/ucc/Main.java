package Maria.ucc;

import java.util.Base64;

// Clase abstracta con el método plantilla
abstract class GeneradorReporte {
    public final void generar() {
        obtenerDatos();
        generarEncabezado();
        generarContenido();
        generarPie();
        formatear();
    }

    protected void obtenerDatos() {
        System.out.println("Obteniendo datos de la base...");
    }

    protected void generarEncabezado() {
        System.out.println("Generando encabezado del reporte.");
    }

    protected void generarPie() {
        System.out.println("Agregando pie de página.");
    }

    protected abstract void generarContenido();
    protected abstract void formatear();
}

// Implementación para PDF
class ReportePDF extends GeneradorReporte {
    @Override
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en PDF.");
    }

    @Override
    protected void formatear() {
        System.out.println("Formateando como documento PDF.");
    }
}

// Implementación para Excel
class ReporteExcel extends GeneradorReporte {
    @Override
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en celdas Excel.");
    }

    @Override
    protected void formatear() {
        System.out.println("Formateando como hoja Excel.");
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        GeneradorReporte pdf = new ReportePDF();
        GeneradorReporte excel = new ReporteExcel();

        System.out.println("==== Generando PDF ====");
        pdf.generar();

        System.out.println("\n==== Generando Excel ====");
        excel.generar();

        // Métodos requeridos
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    // Método que retorna el nombre completo codificado en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método que indica qué patrón se implementó
    public static String getPatron() {
        return "Patrón Template Method";
    }
}
