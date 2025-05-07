package Maria.ucc;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Sistema de Monitoreo de Sensores en una Planta Industrial");
        System.out.println("   Julia es responsable de monitorear sensores de temperatura.");
        System.out.println("   Cuando un sensor supera los 8 °C, deben ocurrir varias acciones:");
        System.out.println("      - Notificación al gerente por correo.");
        System.out.println("      - Registro del evento en la base de datos.");
        System.out.println("      - Generación de orden de verificación técnica.");
        System.out.println("   Antes todo esto estaba en una clase Sensor difícil de mantener.");
        System.out.println("   Con el Patrón Observer, Julia separó responsabilidades.");
        System.out.println("   Ahora puede añadir o quitar observadores sin modificar el sensor.");
        System.out.println("============================");
    }

    // Interfaz del observador
    interface Observador {
        void actualizar(double temperatura);
    }

    // Sujeto (Sensor)
    static class Sensor {
        private List<Observador> observadores = new ArrayList<>();
        private double temperatura;

        public void agregarObservador(Observador o) {
            observadores.add(o);
        }

        public void removerObservador(Observador o) {
            observadores.remove(o);
        }

        public void setTemperatura(double temperatura) {
            this.temperatura = temperatura;
            notificarObservadores();
        }

        private void notificarObservadores() {
            for (Observador o : observadores) {
                o.actualizar(temperatura);
            }
        }
    }

    // Observador 1: Notificación por correo
    static class NotificadorEmail implements Observador {
        public void actualizar(double temperatura) {
            if (temperatura > 8.0) {
                System.out.println("Email enviado: temperatura alta -> " + temperatura + "°C");
            }
        }
    }

    // Observador 2: Registro en sistema
    static class RegistroEvento implements Observador {
        public void actualizar(double temperatura) {
            if (temperatura > 8.0) {
                System.out.println("Evento registrado en base de datos -> " + temperatura + "°C");
            }
        }
    }

    // Observador 3: Orden de verificación
    static class OrdenTecnica implements Observador {
        public void actualizar(double temperatura) {
            if (temperatura > 8.0) {
                System.out.println("Orden de revisión técnica generada.");
            }
        }
    }

    // Cliente principal
    public static void main(String[] args) {
        mostrarEncabezado();

        Sensor sensor = new Sensor();
        sensor.agregarObservador(new NotificadorEmail());
        sensor.agregarObservador(new RegistroEvento());
        sensor.agregarObservador(new OrdenTecnica());

        System.out.println("\nSimulación 1: Temperatura = 6.5°C");
        sensor.setTemperatura(6.5); // No se notifica

        System.out.println("\nSimulación 2: Temperatura = 8.5°C");
        sensor.setTemperatura(8.5); // Se notifican todos los observadores

        // Métodos complementarios
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    // Método que retorna el nombre completo codificado en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return java.util.Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método que indica qué patrón se implementó
    public static String getPatron() {
        return "Patrón Observer";
    }
}
