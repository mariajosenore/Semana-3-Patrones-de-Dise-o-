package cliente;
import java.util.Base64;



public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();

        FacadeReservaHotel facade = new FacadeReservaHotel();
        facade.reservar();

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
        System.out.println("   Como usuario,");
        System.out.println("   quiero reservar un hotel en línea sin tener que interactuar");
        System.out.println("   con reservas, pagos y facturación manualmente.");
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Fachada (Facade)";
    }
}
