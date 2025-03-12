package Src.edu.Maria;
import java.util.Base64;



public class Boleto {
    private String clase;
    private boolean equipajeExtra;
    private boolean seleccionAsiento;
    private boolean comidaEspecial;

    private Boleto(BoletoBuilder builder) {
        this.clase = builder.clase;
        this.equipajeExtra = builder.equipajeExtra;
        this.seleccionAsiento = builder.seleccionAsiento;
        this.comidaEspecial = builder.comidaEspecial;
    }

    // Método para mostrar los detalles del boleto
    public void mostrarDetalles() {
        StringBuilder detalles = new StringBuilder("Clase: " + clase);
        
        if (equipajeExtra) {
            detalles.append(", Equipaje Extra");
        }
        
        if (seleccionAsiento) {
            detalles.append(", Selección de Asiento");
        }
        
        if (comidaEspecial) {
            detalles.append(", Comida Especial");
        }

        System.out.println(detalles.toString());
    }

    // Builder para crear un Boleto
    public static class BoletoBuilder {
        private String clase;
        private boolean equipajeExtra;
        private boolean seleccionAsiento;
        private boolean comidaEspecial;

        // Constructor para inicializar la clase del boleto
        public BoletoBuilder(String clase) {
            this.clase = clase;
        }

        // Método para agregar equipaje extra
        public BoletoBuilder agregarEquipajeExtra() {
            this.equipajeExtra = true;
            return this;
        }

        // Método para seleccionar asiento
        public BoletoBuilder seleccionarAsiento() {
            this.seleccionAsiento = true;
            return this;
        }

        // Método para agregar comida especial
        public BoletoBuilder agregarComidaEspecial() {
            this.comidaEspecial = true;
            return this;
        }

        // Método para construir el objeto Boleto
        public Boleto build() {
            return new Boleto(this);
        }
    }

    // Método para obtener la identidad del desarrollador codificada en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";  // Cambia esto por tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Patrón implementado: Builder";
    }

    // Método para mostrar la historia de usuario
    public static void mostrarHistoriaDeUsuario() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("📜 Historia de usuario:");
        System.out.println("   Como ingeniero de software en una aerolínea,");
        System.out.println("   necesito un sistema de gestión de reservas de vuelos que permita a los clientes personalizar su boleto");
        System.out.println("   eligiendo la clase del vuelo (económica, ejecutiva, primera clase) y los servicios adicionales");
        System.out.println("   (equipaje extra, selección de asiento, comida especial). El sistema debe facilitar la creación de boletos");
        System.out.println("   personalizados sin alterar la lógica principal.");
        System.out.println("🚀============================🚀");
    }

    // Clase principal para probar la implementación
    public static void main(String[] args) {
        // Mostrar historia de usuario
        mostrarHistoriaDeUsuario();

        // Creación de un boleto personalizado
        Boleto boleto = new Boleto.BoletoBuilder("Primera Clase")
                            .agregarEquipajeExtra()
                            .seleccionarAsiento()
                            .agregarComidaEspecial()
                            .build();

        // Mostrar los detalles del boleto
        boleto.mostrarDetalles();

        // Mostrar identidad codificada en base64
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
    }
}
