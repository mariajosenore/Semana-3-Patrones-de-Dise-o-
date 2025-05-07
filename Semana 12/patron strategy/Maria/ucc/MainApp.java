package Maria.ucc;

import java.util.Base64;

// Estrategia
interface EstrategiaImpuesto {
    double calcular(double monto);
}

// Implementación para Colombia
class ImpuestoColombia implements EstrategiaImpuesto {
    public double calcular(double monto) {
        return monto * 0.19;
    }
}

// Implementación para Argentina
class ImpuestoArgentina implements EstrategiaImpuesto {
    public double calcular(double monto) {
        return monto * 0.21;
    }
}

// Implementación para Ecuador
class ImpuestoEcuador implements EstrategiaImpuesto {
    public double calcular(double monto) {
        return 0.0;
    }
}

// Contexto
class CalculadoraImpuesto {
    private EstrategiaImpuesto estrategia;

    public void setEstrategia(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularImpuesto(double monto) {
        return estrategia.calcular(monto);
    }
}

// Clase principal
public class MainApp {

    public static void main(String[] args) {
        mostrarEncabezado();

        CalculadoraImpuesto calculadora = new CalculadoraImpuesto();

        calculadora.setEstrategia(new ImpuestoColombia());
        System.out.println("Colombia: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoArgentina());
        System.out.println("Argentina: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoEcuador());
        System.out.println("Ecuador: " + calculadora.calcularImpuesto(100000));

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Aplicación de cálculo de impuestos en un ERP de una empresa logística.");
        System.out.println("   Camila es una ingeniera de software encargada del módulo de facturación.");
        System.out.println("   Su sistema debe calcular el impuesto según el país del cliente:");
        System.out.println("      - Si el país es Colombia, se aplica el 19% de IVA.");
        System.out.println("      - Si es Argentina, se aplica el 21% de IVA.");
        System.out.println("      - En Ecuador, no se aplica impuesto.");
        System.out.println("   Inicialmente, Camila implementó condicionales para cada país,");
        System.out.println("   pero cada cambio fiscal requería modificar la clase,");
        System.out.println("   violando el principio abierto/cerrado.");
        System.out.println("   Usando el Patrón Estrategia, ahora puede extender el cálculo de impuestos");
        System.out.println("   sin modificar el código existente, cumpliendo buenas prácticas de diseño.");
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "Patrón Estrategia";
    }
}
