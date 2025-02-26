package semana_3.singletons3;

public class Logger {
    private static Logger instance;

    // Constructor privado para evitar instancias fuera de la clase
    private Logger() {}

    // Método estático para obtener la única instancia (Singleton)
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Método para imprimir logs
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
