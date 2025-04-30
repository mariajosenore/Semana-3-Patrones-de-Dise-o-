package implementacion;

import interfaces.IReporte;

public class ReporteReal implements IReporte {
    public void mostrar() {
        System.out.println("Mostrando reporte confidencial.");
    }
}
