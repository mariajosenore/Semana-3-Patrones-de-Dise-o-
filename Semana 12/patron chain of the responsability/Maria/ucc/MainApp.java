package Maria.ucc;

import java.util.Base64;

public class MainApp {

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Panel de control en una aplicación de automatización de oficinas.");
        System.out.println("   Santiago es desarrollador en una startup de domótica que permite controlar");
        System.out.println("   luces, cortinas y aire acondicionado desde una app móvil.");
        System.out.println("   Antes, Santiago usaba condicionales como if (tipo.equals(\"LUZ\")) {...}");
        System.out.println("   lo cual violaba el principio abierto/cerrado.");
        System.out.println("   Aplicando el Patrón Cadena de Responsabilidad, delega la solicitud de aprobación");
        System.out.println("   en una cadena de objetos (supervisor, jefe, director),");
        System.out.println("   cada uno con autoridad para aprobar diferentes montos.");
        System.out.println("============================");
    }

    // Interfaz manejador
    abstract static class Aprobador {
        protected Aprobador siguiente;

        public void setSiguiente(Aprobador siguiente) {
            this.siguiente = siguiente;
        }

        public abstract void procesarSolicitud(double monto);
    }

    // Supervisor
    static class Supervisor extends Aprobador {
        public void procesarSolicitud(double monto) {
            if (monto <= 500) {
                System.out.println("Aprobado por Supervisor.");
            } else if (siguiente != null) {
                siguiente.procesarSolicitud(monto);
            }
        }
    }

    // Jefe de Departamento
    static class JefeDepartamento extends Aprobador {
        public void procesarSolicitud(double monto) {
            if (monto <= 5000) {
                System.out.println("Aprobado por Jefe de Departamento.");
            } else if (siguiente != null) {
                siguiente.procesarSolicitud(monto);
            }
        }
    }

    // Director Financiero
    static class DirectorFinanciero extends Aprobador {
        public void procesarSolicitud(double monto) {
            if (monto > 5000) {
                System.out.println("Aprobado por Director Financiero.");
            } else if (siguiente != null) {
                siguiente.procesarSolicitud(monto);
            }
        }
    }

    public static void main(String[] args) {
        mostrarEncabezado();

        // Crear cadena de aprobación
        Aprobador supervisor = new Supervisor();
        Aprobador jefe = new JefeDepartamento();
        Aprobador director = new DirectorFinanciero();

        supervisor.setSiguiente(jefe);
        jefe.setSiguiente(director);

        // Pruebas
        supervisor.procesarSolicitud(300);   // Supervisor
        supervisor.procesarSolicitud(3000);  // Jefe de Departamento
        supervisor.procesarSolicitud(15000); // Director Financiero

        // Datos adicionales
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "Patrón Cadena de Responsabilidad";
    }
}
