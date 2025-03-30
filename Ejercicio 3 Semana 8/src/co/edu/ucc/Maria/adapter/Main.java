package co.edu.ucc.Maria.adapter;
import java.util.Base64;

interface CanalNotificacion {
    void enviar(String mensaje);
}

class Email implements CanalNotificacion {
    public void enviar(String mensaje) {
        System.out.println("Email enviado: " + mensaje);
    }
}

class SMS implements CanalNotificacion {
    public void enviar(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}

// Abstracción
abstract class Notificador {
    protected CanalNotificacion canal;

    public Notificador(CanalNotificacion canal) {
        this.canal = canal;
    }

    public abstract void notificar(String mensaje);
}

class NotificadorOrden extends Notificador {
    public NotificadorOrden(CanalNotificacion canal) {
        super(canal);
    }

    public void notificar(String mensaje) {
        canal.enviar("Orden: " + mensaje);
    }
}

class NotificadorFactura extends Notificador {
    public NotificadorFactura(CanalNotificacion canal) {
        super(canal);
    }

    public void notificar(String mensaje) {
        canal.enviar("Factura: " + mensaje);
    }
}

// Adaptador de Correo
interface EnviadorCorreo {
    void enviarCorreo(String destino, String contenido);
}

class CorreoLegacy {
    public void enviarMensaje(String texto, String email) {
        System.out.println("Enviando a " + email + ": " + texto);
    }
}

class AdaptadorCorreo implements EnviadorCorreo {
    private CorreoLegacy correo;

    public AdaptadorCorreo(CorreoLegacy correo) {
        this.correo = correo;
    }

    public void enviarCorreo(String destino, String contenido) {
        correo.enviarMensaje(contenido, destino);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        
        Notificador noti1 = new NotificadorOrden(new Email());
        Notificador noti2 = new NotificadorFactura(new SMS());

        noti1.notificar("Tu pedido ha sido enviado.");
        noti2.notificar("Tu factura está lista.");
        
        EnviadorCorreo servicio = new AdaptadorCorreo(new CorreoLegacy());
        servicio.enviarCorreo("cliente@ejemplo.com", "Bienvenido a la plataforma");
    }

    public static void mostrarEncabezado() {
        System.out.println("========================================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("========================================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("========================================");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Bridge y Adapter";
    }
}
