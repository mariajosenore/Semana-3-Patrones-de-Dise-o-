


import java.util.Queue;
import java.util.LinkedList;
 
class EquipoVR {
    private String id;
    
    public EquipoVR(String id) {
        this.id = id;
        System.out.println("Nuevo equipo VR disponible: " + id);
    }
    
    public void asignarUsuario(String usuario) {
        System.out.println("Equipo VR " + id + " asignado a " + usuario);
    }
}
 
class PoolEquiposVR {
    private Queue<EquipoVR> pool;
    @SuppressWarnings("unused")
    private int limite;
 
    public PoolEquiposVR(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new EquipoVR("VR-" + (i + 1)));
        }
    }
    
    public EquipoVR obtenerEquipo() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay equipos VR disponibles, espere...");
            return null;
        }
    }
    
    public void liberarEquipo(EquipoVR equipo) {
        pool.offer(equipo);
    }
}
 
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PoolEquiposVR pool = new PoolEquiposVR(3);
        
        EquipoVR e1 = pool.obtenerEquipo();
        EquipoVR e2 = pool.obtenerEquipo();
        
        e1.asignarUsuario("Carlos");
        pool.liberarEquipo(e1);
        
        EquipoVR e3 = pool.obtenerEquipo();
        e3.asignarUsuario("Ana");
    }
}
    
    