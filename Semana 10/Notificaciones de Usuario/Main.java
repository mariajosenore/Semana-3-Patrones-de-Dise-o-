import java.util.Base64;

// Interfaz común para las notificaciones
interface Notificacion {
    void enviar(String mensaje); // Método para enviar la notificación
}

// Clase NotificacionBasica que implementa la interfaz Notificacion
class NotificacionBasica implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("Notificación básica: " + mensaje);
    }
}

// Clase abstracta que actúa como un decorador para las notificaciones
abstract class NotificacionDecorator implements Notificacion {
    protected Notificacion wrappee;

    public NotificacionDecorator(Notificacion n) {
        this.wrappee = n;
    }

    public void enviar(String mensaje) {
        wrappee.enviar(mensaje); // Delegamos la llamada al objeto envuelto
    }
}

// Clase NotificacionEmail que decora la notificación básica para enviar por email
class NotificacionEmail extends NotificacionDecorator {
    public NotificacionEmail(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando email: " + mensaje); // Añadimos la lógica de email
    }
}

// Clase NotificacionSMS que decora la notificación básica para enviar por SMS
class NotificacionSMS extends NotificacionDecorator {
    public NotificacionSMS(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando SMS: " + mensaje); // Añadimos la lógica de SMS
    }
}

// Clase principal
public class Main {
    // Método para obtener identidad codificada en Base64
    public static String getIdentidad() {
        String identidad = "Sistema de Notificaciones - Decorator";
        return Base64.getEncoder().encodeToString(identidad.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Decorator";
    }

    // Método para mostrar información adicional
    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como responsable de comunicación, quiero que las notificaciones puedan");
        System.out.println("   enviarse por email, SMS y notificaciones push sin modificar el código base.");
        System.out.println("============================");
    }

    public static void main(String[] args) {
        // Mostrar encabezado con la información
        mostrarEncabezado();

        // Crear una notificación básica
        Notificacion notificacion = new NotificacionBasica();

        // Decorar la notificación con email
        Notificacion notificacionConEmail = new NotificacionEmail(notificacion);

        // Decorar la notificación con SMS
        Notificacion notificacionConSMS = new NotificacionSMS(notificacionConEmail);

        // Enviar la notificación por email y SMS
        System.out.println("Enviando notificación:");
        notificacionConSMS.enviar("¡Hola! Tienes una nueva actualización.");

        // Mostrar la identidad y el patrón implementado
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }
}
