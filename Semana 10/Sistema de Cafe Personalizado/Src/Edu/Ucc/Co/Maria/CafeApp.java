package Src.Edu.Ucc.Co.Maria;
import java.util.Base64;

// Interfaz base
interface Cafe {
    String descripcion();
    double costo();
}

// Clase concreta base
class CafeBasico implements Cafe {
    public String descripcion() { return "Café básico"; }
    public double costo() { return 5.0; }
}

// Clase decoradora abstracta
abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    public String descripcion() {
        return cafe.descripcion();
    }

    public double costo() {
        return cafe.costo();
    }

    // Método para codificar nombre en Base64
    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    // Método que indica el patrón usado
    public static String getPatron() {
        return "Decorator";
    }

    // Encabezado con datos y la historia de usuario correcta
    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como barista digital en una app de pedidos,");
        System.out.println("   necesito permitir a los usuarios personalizar su café");
        System.out.println("   con azúcar, leche, sabores, sin modificar la clase base.");
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }
}

// Decoradores concretos
class ConLeche extends CafeDecorator {
    public ConLeche(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Leche";
    }

    public double costo() {
        return super.costo() + 1.5;
    }
}

class ConAzucar extends CafeDecorator {
    public ConAzucar(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Azúcar";
    }

    public double costo() {
        return super.costo() + 0.5;
    }
}

// Clase principal para ejecutar el programa
public class CafeApp {
    public static void main(String[] args) {
        // Creamos un café básico y lo personalizamos con decoradores
        Cafe cafe = new CafeBasico();
        cafe = new ConLeche(cafe);
        cafe = new ConAzucar(cafe);

        // Mostramos el pedido final
        System.out.println("Tu pedido: " + cafe.descripcion());
        System.out.println("Costo total: $" + cafe.costo());

        // Mostramos el encabezado con info del patrón
        CafeDecorator.mostrarEncabezado();
    }
}
