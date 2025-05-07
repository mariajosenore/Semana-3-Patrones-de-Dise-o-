package Maria.ucc.edu;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Main {

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Sistema de contabilidad que genera diferentes reportes sobre activos.");
        System.out.println("   Francisco trabaja en un sistema contable que maneja diferentes tipos de activos:");
        System.out.println("   Inmuebles, Vehículos, Equipos.");
        System.out.println("   El sistema debe generar reportes fiscales y financieros sobre estos activos.");
        System.out.println("   Cada tipo de activo tiene reglas distintas para el cálculo de depreciación,");
        System.out.println("   valor residual e impacto contable. Además, los reportes pueden cambiar con la normativa legal.");
        System.out.println("   En lugar de modificar las clases Activo, Inmueble, Vehículo cada vez que se agrega");
        System.out.println("   una operación nueva, Francisco implementa el patrón Visitor.");
        System.out.println("   Define una interfaz ActivoVisitor con métodos visitar(Inmueble), visitar(Vehiculo), etc.");
        System.out.println("   Las operaciones como ReporteFiscalVisitor, ReporteFinancieroVisitor implementan esa interfaz");
        System.out.println("   y aplican lógica según el tipo de activo.");
        System.out.println("   Esto permitió agregar nuevas operaciones sin modificar las clases base,");
        System.out.println("   y separar completamente la lógica contable de la lógica de presentación.");
        System.out.println("============================");
    }

    public static void main(String[] args) {
        mostrarEncabezado();

        List<Activo> activos = new ArrayList<>();
        activos.add(new Inmueble());
        activos.add(new Vehiculo());

        ActivoVisitor reporte = new ReporteFiscalVisitor();

        for (Activo a : activos) {
            a.aceptar(reporte);
        }

        // Ejecutar los métodos requeridos
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    // Retorna el nombre completo codificado en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Indica el patrón implementado
    public static String getPatron() {
        return "Patrón Visitor";
    }
}

// Interfaz del Visitor
interface ActivoVisitor {
    void visitar(Inmueble i);
    void visitar(Vehiculo v);
}

// Interfaz del elemento visitable
interface Activo {
    void aceptar(ActivoVisitor visitor);
}

// Elemento 1: Inmueble
class Inmueble implements Activo {
    public void aceptar(ActivoVisitor visitor) {
        visitor.visitar(this);
    }

    public double calcularValorFiscal() {
        return 100000;
    }
}

// Elemento 2: Vehículo
class Vehiculo implements Activo {
    public void aceptar(ActivoVisitor visitor) {
        visitor.visitar(this);
    }

    public double calcularValorFiscal() {
        return 35000;
    }
}

// Visitor concreto: Reporte Fiscal
class ReporteFiscalVisitor implements ActivoVisitor {
    public void visitar(Inmueble i) {
        System.out.println("Inmueble - Valor fiscal: $" + i.calcularValorFiscal());
    }

    public void visitar(Vehiculo v) {
        System.out.println("Vehículo - Valor fiscal: $" + v.calcularValorFiscal());
    }
}
