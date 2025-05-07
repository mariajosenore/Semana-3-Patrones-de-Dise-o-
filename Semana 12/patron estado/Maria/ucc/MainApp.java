package Maria.ucc;

import java.util.Base64;

public class MainApp {

    // Método que muestra el encabezado con la historia de usuario
    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Cajero automático con múltiples estados de operación.");
        System.out.println("   Andrés trabaja en el equipo de desarrollo de una fintech que quiere simular un cajero automático en software.");
        System.out.println("   Este cajero debe tener comportamientos distintos dependiendo del estado actual:");
        System.out.println("      - Cuando sin tarjeta, debe pedir que se inserte una.");
        System.out.println("      - Cuando con tarjeta, debe solicitar PIN.");
        System.out.println("      - Cuando autenticado, debe permitir operaciones.");
        System.out.println("   La implementación inicial se basaba en muchos condicionales, lo que dificultaba las pruebas unitarias y el mantenimiento.");
        System.out.println("   Andrés decide usar el patrón State para encapsular la lógica específica en clases separadas.");
        System.out.println("   El objeto Cajero mantiene una referencia al estado actual y delega en él el comportamiento.");
        System.out.println("   Ahora, el sistema es más legible, cada estado es fácilmente extensible, y nuevos estados (como Bloqueado) pueden");
        System.out.println("   ser añadidos sin alterar el código existente.");
        System.out.println("============================");
    }

    // Interfaz de Estado
    interface EstadoCajero {
        void insertarTarjeta();
        void ingresarPin(int pin);
        void retirarDinero(double monto);
    }

    // Estado: sin tarjeta
    static class SinTarjeta implements EstadoCajero {
        private Cajero cajero;

        public SinTarjeta(Cajero cajero) {
            this.cajero = cajero;
        }

        public void insertarTarjeta() {
            System.out.println("Tarjeta insertada.");
            cajero.setEstado(new ConTarjeta(cajero));
        }

        public void ingresarPin(int pin) {
            System.out.println("Primero inserte una tarjeta.");
        }

        public void retirarDinero(double monto) {
            System.out.println("Primero inserte una tarjeta.");
        }
    }

    // Estado: con tarjeta (esperando PIN)
    static class ConTarjeta implements EstadoCajero {
        private Cajero cajero;

        public ConTarjeta(Cajero cajero) {
            this.cajero = cajero;
        }

        public void insertarTarjeta() {
            System.out.println("Ya hay una tarjeta insertada.");
        }

        public void ingresarPin(int pin) {
            if (pin == 1234) {
                System.out.println("PIN correcto.");
                cajero.setEstado(new Autenticado(cajero));
            } else {
                System.out.println("PIN incorrecto.");
            }
        }

        public void retirarDinero(double monto) {
            System.out.println("Debe ingresar su PIN primero.");
        }
    }

    // Estado: autenticado
    static class Autenticado implements EstadoCajero {
        private Cajero cajero;

        public Autenticado(Cajero cajero) {
            this.cajero = cajero;
        }

        public void insertarTarjeta() {
            System.out.println("Ya autenticado. No necesita reiniciar.");
        }

        public void ingresarPin(int pin) {
            System.out.println("Ya autenticado.");
        }

        public void retirarDinero(double monto) {
            System.out.println("Retirando $" + monto);
            cajero.setEstado(new SinTarjeta(cajero));
        }
    }

    // Contexto: Cajero
    static class Cajero {
        private EstadoCajero estado;

        public Cajero() {
            this.estado = new SinTarjeta(this);
        }

        public void setEstado(EstadoCajero estado) {
            this.estado = estado;
        }

        public void insertarTarjeta() {
            estado.insertarTarjeta();
        }

        public void ingresarPin(int pin) {
            estado.ingresarPin(pin);
        }

        public void retirarDinero(double monto) {
            estado.retirarDinero(monto);
        }
    }

    // Métodos para Base64 y patrón implementado
    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "Patrón State";
    }

    // Cliente
    public static void main(String[] args) {
        mostrarEncabezado();
        
        Cajero cajero = new Cajero();

        cajero.insertarTarjeta();       // Transición a ConTarjeta
        cajero.ingresarPin(1111);       // PIN incorrecto
        cajero.ingresarPin(1234);       // PIN correcto, transición a Autenticado
        cajero.retirarDinero(200);      // Retiro y transición a SinTarjeta

        // Mostrar resultados con Base64 y patrón
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }
}
