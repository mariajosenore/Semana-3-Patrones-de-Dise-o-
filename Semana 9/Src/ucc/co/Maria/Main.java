package ucc.co.Maria;
import java.util.Base64;

public class Main {

    // Interfaz común para los dispositivos GPS
    public interface GPSInterface {
        String obtenerUbicacion();
        String obtenerEstado();
    }

    // Dispositivos simulados (Garmin, TomTom, Huawei)
    public static class GarminDevice {
        public String getLocation() {
            return "Lat: 40.7128, Lon: -74.0060 (Nueva York)";
        }

        public String getStatus() {
            return "Activo";
        }
    }

    public static class TomTomDevice {
        public String getLocation() {
            return "Lat: 51.5074, Lon: -0.1278 (Londres)";
        }

        public String getStatus() {
            return "Activo";
        }
    }

    public static class HuaweiDevice {
        public String getLocation() {
            return "Lat: 34.0522, Lon: -118.2437 (Los Ángeles)";
        }

        public String getStatus() {
            return "Inactivo";
        }
    }

    public static class GarminDevice2 {
        public String getLocation() {
            return "Lat: 48.8566, Lon: 2.3522 (París)";
        }

        public String getStatus() {
            return "Activo";
        }
    }

    public static class TomTomDevice2 {
        public String getLocation() {
            return "Lat: 40.730610, Lon: -73.935242 (Brooklyn)";
        }

        public String getStatus() {
            return "Inactivo";
        }
    }

    // Adapter para cada dispositivo GPS
    public static class GarminAdapter implements GPSInterface {
        private GarminDevice garminDevice;

        public GarminAdapter(GarminDevice garminDevice) {
            this.garminDevice = garminDevice;
        }

        @Override
        public String obtenerUbicacion() {
            return garminDevice.getLocation();
        }

        @Override
        public String obtenerEstado() {
            return garminDevice.getStatus();
        }
    }

    public static class TomTomAdapter implements GPSInterface {
        private TomTomDevice tomTomDevice;

        public TomTomAdapter(TomTomDevice tomTomDevice) {
            this.tomTomDevice = tomTomDevice;
        }

        @Override
        public String obtenerUbicacion() {
            return tomTomDevice.getLocation();
        }

        @Override
        public String obtenerEstado() {
            return tomTomDevice.getStatus();
        }
    }

    public static class HuaweiAdapter implements GPSInterface {
        private HuaweiDevice huaweiDevice;

        public HuaweiAdapter(HuaweiDevice huaweiDevice) {
            this.huaweiDevice = huaweiDevice;
        }

        @Override
        public String obtenerUbicacion() {
            return huaweiDevice.getLocation();
        }

        @Override
        public String obtenerEstado() {
            return huaweiDevice.getStatus();
        }
    }

    public static class GarminAdapter2 implements GPSInterface {
        private GarminDevice2 garminDevice;

        public GarminAdapter2(GarminDevice2 garminDevice) {
            this.garminDevice = garminDevice;
        }

        @Override
        public String obtenerUbicacion() {
            return garminDevice.getLocation();
        }

        @Override
        public String obtenerEstado() {
            return garminDevice.getStatus();
        }
    }

    public static class TomTomAdapter2 implements GPSInterface {
        private TomTomDevice2 tomTomDevice;

        public TomTomAdapter2(TomTomDevice2 tomTomDevice) {
            this.tomTomDevice = tomTomDevice;
        }

        @Override
        public String obtenerUbicacion() {
            return tomTomDevice.getLocation();
        }

        @Override
        public String obtenerEstado() {
            return tomTomDevice.getStatus();
        }
    }

    // Interfaz para la interfaz gráfica del rastreo
    public interface RastreoInterface {
        void mostrarRastreo(GPSInterface gps);
    }

    // Implementación para escritorio
    public static class RastreoDesktop implements RastreoInterface {
        @Override
        public void mostrarRastreo(GPSInterface gps) {
            String ubicacion = gps.obtenerUbicacion();
            String estado = gps.obtenerEstado();
            System.out.println("Mostrando rastreo en escritorio: Ubicación: " + ubicacion + ", Estado: " + estado);
        }
    }

    // Implementación para móvil
    public static class RastreoMovil implements RastreoInterface {
        @Override
        public void mostrarRastreo(GPSInterface gps) {
            String ubicacion = gps.obtenerUbicacion();
            String estado = gps.obtenerEstado();
            System.out.println("Mostrando rastreo en móvil: Ubicación: " + ubicacion + ", Estado: " + estado);
        }
    }

    // Clase principal para el rastreo
    public static class Rastreo {
        private GPSInterface gpsAdapter;
        private RastreoInterface interfaz;

        public Rastreo(GPSInterface gpsAdapter, RastreoInterface interfaz) {
            this.gpsAdapter = gpsAdapter;
            this.interfaz = interfaz;
        }

        public void rastrear() {
            interfaz.mostrarRastreo(gpsAdapter);
        }
    }

    // Método para obtener identidad codificada en base64
    public static String getIdentidad() {
        String identidad = "Sistema de Rastreo Logístico";
        return Base64.getEncoder().encodeToString(identidad.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Adapter y Bridge";
    }

    // Método para mostrar el encabezado con los datos solicitados
    public static void mostrarEncabezado() {
        System.out.println("============================");
        System.out.println("Nombre: María José");
        System.out.println("Universidad: Universidad Cooperativa de Colombia");
        System.out.println("Campus: Cali");
        System.out.println("Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("Historia de usuario:");
        System.out.println("   Como ingeniero de integración en una empresa de logística nacional,");
        System.out.println("   necesito que nuestro sistema de rastreo de vehículos sea capaz de integrarse con");
        System.out.println("   múltiples dispositivos GPS de diferentes marcas (Garmin, TomTom, Huawei), cada uno");
        System.out.println("   con su propia API, para mostrar de forma unificada los datos de ubicación y estado del");
        System.out.println("   vehículo en una aplicación móvil y de escritorio.");
        System.out.println("   Además, quiero poder modificar la interfaz gráfica del panel de rastreo dependiendo de");
        System.out.println("   si el usuario accede desde escritorio o desde el celular, sin tener que cambiar toda");
        System.out.println("   la lógica del sistema.");
        System.out.println("============================");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("============================");
    }

    public static void main(String[] args) {
        // Mostrar encabezado con la información
        mostrarEncabezado();

        // Crear los dispositivos reales
        GarminDevice garminDevice = new GarminDevice();
        TomTomDevice tomTomDevice = new TomTomDevice();
        GarminDevice2 garminDevice2 = new GarminDevice2();
        TomTomDevice2 tomTomDevice2 = new TomTomDevice2();

        // Crear los adaptadores para cada dispositivo
        GPSInterface garminAdapter = new GarminAdapter(garminDevice);
        GPSInterface tomTomAdapter = new TomTomAdapter(tomTomDevice);
        GPSInterface garminAdapter2 = new GarminAdapter2(garminDevice2);
        GPSInterface tomTomAdapter2 = new TomTomAdapter2(tomTomDevice2);

        // Crear interfaces de usuario (escritorio y móvil)
        RastreoInterface interfazEscritorio = new RastreoDesktop();
        RastreoInterface interfazMovil = new RastreoMovil();

        // Crear y usar el sistema de rastreo con escritorio
        Rastreo rastreoEscritorio = new Rastreo(garminAdapter, interfazEscritorio);
        rastreoEscritorio.rastrear();

        Rastreo rastreoEscritorio2 = new Rastreo(garminAdapter2, interfazEscritorio);
        rastreoEscritorio2.rastrear();

        // Crear y usar el sistema de rastreo con móvil
        Rastreo rastreoMovil = new Rastreo(tomTomAdapter, interfazMovil);
        rastreoMovil.rastrear();

        Rastreo rastreoMovil2 = new Rastreo(tomTomAdapter2, interfazMovil);
        rastreoMovil2.rastrear();
    }
}
