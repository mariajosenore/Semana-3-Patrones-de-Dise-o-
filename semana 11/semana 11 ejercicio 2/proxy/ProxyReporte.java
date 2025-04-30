package proxy;

import implementacion.ReporteReal;
import interfaces.IReporte;

public class ProxyReporte implements IReporte {
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
