package Cliente;

import java.util.Base64;

interface IReporte {
    void mostrar();
}

class ReporteReal implements IReporte {
    public void mostrar() {
        System.out.println("Mostrando reporte confidencial.");
    }
}

class ProxyReporte implements IReporte {
    private ReporteReal reporteReal;
    private String rolUsuario;

    public ProxyReporte(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void mostrar() {
        if ("gerente".equalsIgnoreCase(rolUsuario)) {
            if (reporteReal == null) {
                reporteReal = new ReporteReal();
            }
            reporteReal.mostrar();
        } else {
            System.out.println("Acceso denegado: " + rolUsuario);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();

        IReporte reporte1 = new ProxyReporte("gerente");
        reporte1.mostrar();

        IReporte reporte2 = new ProxyReporte("empleado");
        reporte2.mostrar();

        System.out.println("============================");
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
        System.out.println("   Como gerente, quiero visualizar reportes confidenciales");
        System.out.println("   solo si tengo permisos válidos.");
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Patrón Proxy";
    }
}
