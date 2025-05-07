package Maria.ucc;

import java.util.Base64;

// Interfaz Comando
interface Comando {
    void ejecutar();
}

// Receptor: dispositivos reales
class Luz {
    public void encender() {
        System.out.println("Luz encendida.");
    }
}

class Cortina {
    public void subir() {
        System.out.println("Cortina subida.");
    }
}

class AireAcondicionado {
    public void activar() {
        System.out.println("Aire acondicionado activado.");
    }
}

// Comandos concretos
class EncenderLuz implements Comando {
    private Luz luz;

    public EncenderLuz(Luz luz) {
        this.luz = luz;
    }

    public void ejecutar() {
        luz.encender();
    }
}

class SubirCortina implements Comando {
    private Cortina cortina;

    public SubirCortina(Cortina cortina) {
        this.cortina = cortina;
    }

    public void ejecutar() {
        cortina.subir();
    }
}

class ActivarAire implements Comando {
    private AireAcondicionado aire;

    public ActivarAire(AireAcondicionado aire) {
        this.aire = aire;
    }

    public void ejecutar() {
        aire.activar();
    }
}

// Invocador: Botón del panel
class Boton {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void presionar() {
        if (comando != null) {
            comando.ejecutar();
        } else {
            System.out.println("No hay comando configurado.");
        }
    }
}

// Clase principal
public class MainApp {

    public static void main(String[] args) {
        mostrarEncabezado();

        // Dispositivos
        Luz luz = new Luz();
        Cortina cortina = new Cortina();
        AireAcondicionado aire = new AireAcondicionado();

        // Comandos
        Comando encenderLuz = new EncenderLuz(luz);
        Comando subirCortina = new SubirCortina(cortina);
        Comando activarAire = new ActivarAire(aire);

        // Botones
        Boton boton1 = new Boton();
        Boton boton2 = new Boton();
        Boton boton3 = new Boton();

        boton1.setComando(encenderLuz);
        boton2.setComando(subirCortina);
        boton3.setComando(activarAire);

        // Simulación de pulsaciones
        boton1.presionar();
        boton2.presionar();
        boton3.presionar();

        // Info adicional
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println("Patrón implementado: " + getPatron());
    }

    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Contexto: Panel de control en una aplicación de automatización de oficinas.");
        System.out.println("   Santiago es desarrollador en una startup de domótica que permite controlar luces, cortinas y aire acondicionado desde una app móvil.");
        System.out.println("   El cliente desea configurar botones que envíen órdenes a distintos dispositivos desde un panel central.");
        System.out.println("   Antes, Santiago usaba condicionales como if (tipo.equals(\"LUZ\")), lo cual no era extensible.");
        System.out.println("   Cada nuevo dispositivo requería modificar código existente, violando el principio abierto/cerrado.");
        System.out.println("   Con el patrón Command, encapsuló cada acción en una clase con el método ejecutar().");
        System.out.println("   Los botones ahora pueden configurarse dinámicamente con nuevas acciones,");
        System.out.println("   soportando funcionalidades como colas de tareas y acciones de deshacer.");
        System.out.println("============================");
    }

    public static String getIdentidad() {
        String nombreCompleto = "María José";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "Patrón Command";
    }
}
