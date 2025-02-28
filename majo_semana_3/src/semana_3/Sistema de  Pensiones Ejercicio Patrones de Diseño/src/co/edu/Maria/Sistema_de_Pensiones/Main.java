package src.co.edu.Maria.Sistema_de_Pensiones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    // Variables dinámicas para personalizar el encabezado
    private static final String NOMBRE = "María José Noreña";
    private static final String UNIVERSIDAD = "Universidad Cooperativa de Colombia";
    private static final String CAMPUS = "Cali";
    private static final String REPOSITORIO_GIT = "https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git";
    private static final String NOMBRE_EJERCICIO = "Liquidación de Pensiones";

    public static void mostrarEncabezado() {
        // Obtener la fecha actual
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("🚀=====================================================🚀");
        System.out.println("👩‍💻 Nombre: " + NOMBRE);
        System.out.println("🏫 Universidad: " + UNIVERSIDAD);
        System.out.println("📍 Campus: " + CAMPUS);
        System.out.println("📂 Repositorio Git: " + REPOSITORIO_GIT);
        System.out.println("📅 Fecha: " + fechaActual);
        System.out.println("📌 Ejercicio: " + NOMBRE_EJERCICIO);
        System.out.println("📝 Historia de Usuario:");
        System.out.println("   Un sistema de liquidación de pensiones requiere procesar varias leyes de liquidación");
        System.out.println("   de pensión para realizar el pago mensual. Para ello, se necesita que el salario de");
        System.out.println("   pensión sea liquidado con base en la ley a la que pertenece, con los siguientes datos:");
        System.out.println("   - Ley 78: 15 salarios");
        System.out.println("   - Ley 86: 5 salarios");
        System.out.println("   - Ley 98: 2.5 salarios");
        System.out.println("   - Ley 100: Promedio últimos 10 años");
        System.out.println("   - Ley Petro: Tope máximo 3.5 salarios y menores solo el 70%");
        System.out.println("🚀=====================================================🚀");
    }

    public static void main(String[] args) {
        mostrarEncabezado(); // Mostrar el encabezado al inicio del programa

        LiquidacionPensiones sistema = new LiquidacionPensiones();
        sistema.procesarLiquidaciones();

        // Ejecutar métodos finales
        System.out.println("Identidad: " + sistema.getIdentidad());
        System.out.println("Patrón: " + sistema.getPatron());
    }
}











































































// public class Main {
//     public static void main(String[] args) {
//         LiquidacionPensiones sistema = new LiquidacionPensiones();
//         sistema.procesarLiquidaciones();

//         // Ejecutar métodos finales
//         System.out.println("Identidad: " + sistema.getIdentidad());
//         System.out.println("Patrón: " + sistema.getPatron());
//     }
// }