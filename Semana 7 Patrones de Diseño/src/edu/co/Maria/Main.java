package src.edu.co.Maria;
import java.util.Queue;
import java.util.LinkedList;
 
class VehiculoTuristico {
    private String id;
    
    public VehiculoTuristico(String id) {
        this.id = id;
        System.out.println("Nuevo vehículo disponible: " + id);
    }
    
    public void asignarRecorrido(String recorrido) {
        System.out.println("Vehículo " + id + " asignado a " + recorrido);
    }
}
 
class PoolVehiculos {
    private Queue<VehiculoTuristico> pool;
    @SuppressWarnings("unused")
    private int limite;
 
    public PoolVehiculos(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new VehiculoTuristico("Vehiculo-" + (i + 1)));
        }
    }
    
    public VehiculoTuristico obtenerVehiculo() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay vehículos disponibles, espere...");
            return null;
        }
    }
    
    public void liberarVehiculo(VehiculoTuristico vehiculo) {
        pool.offer(vehiculo);
    }
}
 
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PoolVehiculos pool = new PoolVehiculos(2);
        
        VehiculoTuristico v1 = pool.obtenerVehiculo();
        VehiculoTuristico v2 = pool.obtenerVehiculo();
        VehiculoTuristico v3 = pool.obtenerVehiculo(); // No hay vehículos disponibles
        
        v1.asignarRecorrido("Tour por la ciudad");
        pool.liberarVehiculo(v1);
        
        VehiculoTuristico v4 = pool.obtenerVehiculo(); // Ahora hay uno disponible
        v4.asignarRecorrido("Visita a las montañas");
    }
}
