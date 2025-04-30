
 package MARIA.UCC.EDU.CO;

 import java.util.Base64;
 
 public class HistorialMedico {
 
     private String nombreCompleto;
     private String historialOriginal;
 
     // Constructor para crear un historial médico
     public HistorialMedico(String nombreCompleto, String historialOriginal) {
         this.nombreCompleto = nombreCompleto;
         this.historialOriginal = historialOriginal;
     }
 
     // Método para clonar el historial médico
     public HistorialMedico clonarHistorial(String nuevaNota) {
         // Crear una nueva versión del historial, agregando la nueva nota
         String historialClonado = this.historialOriginal + "\nNota: " + nuevaNota;
         return new HistorialMedico(this.nombreCompleto, historialClonado);
     }
 
     // Método que retorna el nombre completo codificado en base64
     public String getIdentidad() {
         // Codificar el nombre completo en base64
         return Base64.getEncoder().encodeToString(this.nombreCompleto.getBytes());
     }
 
     // Método que retorna el patrón que se está implementando
     public String getPatron() {
         return "Patrón de clonación de historiales médicos implementado. Se agrega nueva información sin modificar el original.";
     }
 
     // Método para obtener el historial original
     public String getHistorialOriginal() {
         return this.historialOriginal;
     }
 
     // Método para obtener el historial clonado
     public String getHistorialClonado() {
         return this.historialOriginal;  // Este se podría modificar para devolver el historial clonado
     }
 
     public static void main(String[] args) {
         // Imprimir historia de usuario
         System.out.println("Historia de Usuario:");
         System.out.println("Como desarrollador en un hospital digital,");
         System.out.println("necesito clonar historiales médicos de pacientes para crear nuevas versiones");
         System.out.println("con pequeñas variaciones (por ejemplo, agregar una nueva nota médica),");
         System.out.println("sin modificar los registros originales ni construir el documento desde cero.");
         System.out.println("La clonación debe realizarse de manera eficiente para mantener el historial original intacto");
         System.out.println("y crear nuevas versiones que contengan solo las modificaciones necesarias, ");
         System.out.println("como agregar notas o recomendaciones adicionales, sin alterar la estructura básica del registro.");
         System.out.println();
 
         // Crear un historial médico original
         HistorialMedico historial = new HistorialMedico("Juan Pérez", "Historial médico original de Juan Pérez");
 
         // Clonar el historial y agregar una nueva nota
         HistorialMedico historialClonado = historial.clonarHistorial("Nuevo tratamiento recomendado.");
 
         // Imprimir la identidad codificada en base64
         System.out.println("Identidad (Base64): " + historial.getIdentidad());
 
         // Imprimir el patrón implementado
         System.out.println("Patrón Implementado: " + historial.getPatron());
 
         // Mostrar el historial original y clonado
         System.out.println("Historial Original: " + historial.getHistorialOriginal());
         System.out.println("Historial Clonado: " + historialClonado.getHistorialOriginal());
     }
 }
  