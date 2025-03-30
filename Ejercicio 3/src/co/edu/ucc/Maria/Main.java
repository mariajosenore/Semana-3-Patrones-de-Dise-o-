package co.edu.ucc.Maria;
import java.util.Base64;

interface FormatoFactura {
    void generarFactura(String datos);
}

class FormatoPDF implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en PDF: " + datos);
    }
}

class FormatoXML implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en XML: " + datos);
    }
}

abstract class Factura {
    protected FormatoFactura formato;

    public Factura(FormatoFactura formato) {
        this.formato = formato;
    }

    public abstract void emitir(String datos);
}

class FacturaElectronica extends Factura {
    public FacturaElectronica(FormatoFactura formato) {
        super(formato);
    }

    public void emitir(String datos) {
        formato.generarFactura(datos);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        
        Factura factura1 = new FacturaElectronica(new FormatoPDF());
        factura1.emitir("Factura #789 - Total: $1.200.000");
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
