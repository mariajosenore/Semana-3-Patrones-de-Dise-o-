package co.edu.ucc.Maria;



import java.util.Base64;

interface LocalizadorWeb {
    void mostrarUbicacion(String coordenadas);
}

class GPSCamion {
    public String obtenerUbicacion() {
        return "Lat: 4.60971, Lon: -74.08175";
    }
}

class AdaptadorGPS implements LocalizadorWeb {
    private GPSCamion gps;

    public AdaptadorGPS(GPSCamion gps) {
        this.gps = gps;
    }

    public void mostrarUbicacion(String coordenadas) {
        String ubicacion = gps.obtenerUbicacion();
        System.out.println("Ubicación del camión: " + ubicacion);
    }
}

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado();
        LocalizadorWeb localizador = new AdaptadorGPS(new GPSCamion());
        localizador.mostrarUbicacion("");
    }

    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("📜 Historia de usuario:");
        System.out.println("   Como desarrollador de un banco digital,");
        System.out.println("   necesito un sistema que permita a los clientes solicitar diferentes tipos de préstamos");
        System.out.println("   (hipotecario, automotriz, personal) con diferentes tasas de interés y plazos.");
        System.out.println("   El sistema debe garantizar que las reglas de negocio sean aplicadas correctamente según el tipo de préstamo seleccionado.");
        System.out.println("🚀============================🚀");
        System.out.println("Identidad codificada en Base64: " + getIdentidad());
        System.out.println("Patrón utilizado: " + getPatron());
        System.out.println("🚀============================🚀");
    }

    public static String getIdentidad() {
        String nombre = "María José";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public static String getPatron() {
        return "Adaptador";
    }
}
