package src.co.edu.Maria.Sistema_de_Pensiones;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

public class LiquidacionPensiones {
    private List<Persona> personas;

    public LiquidacionPensiones() {
        personas = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Ley 78
        personas.add(new Persona("Ley 78", 850000));
        personas.add(new Persona("Ley 78", 850000));
        personas.add(new Persona("Ley 78", 850000));

        // Ley 86
        personas.add(new Persona("Ley 86", 930000));
        personas.add(new Persona("Ley 86", 930000));

        // Ley 98
        personas.add(new Persona("Ley 98", 1020000));
        personas.add(new Persona("Ley 98", 1020000));
        personas.add(new Persona("Ley 98", 1020000));
        personas.add(new Persona("Ley 98", 2040000)); // Salario doble
        personas.add(new Persona("Ley 98", 2040000)); // Salario doble

        // Ley 100
        personas.add(new Persona("Ley 100", 1200000));
        personas.add(new Persona("Ley 100", 1200000));
        personas.add(new Persona("Ley 100", 1230000)); // Últimos 5 años
        personas.add(new Persona("Ley 100", 1300000)); // Últimos 10-5 años

        // Ley Petro
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
        personas.add(new Persona("Ley Petro", 1400000));
    }

    public void procesarLiquidaciones() {
        for (Persona persona : personas) {
            double salarioLiquidado = calcularSalario(persona);
            System.out.println("Persona bajo " + persona.getLey() + " recibe: $" + salarioLiquidado);
        }
    }

    private double calcularSalario(Persona persona) {
        String ley = persona.getLey();
        double salario = persona.getSalario();

        switch (ley) {
            case "Ley 78":
                return salario * 15;
            case "Ley 86":
                return salario * 5;
            case "Ley 98":
                return salario * 2.5;
            case "Ley 100":
                return salario; // Promedio últimos 10 años (simplificado)
            case "Ley Petro":
                if (salario > 3.5 * 1400000) {
                    return 3.5 * 1400000;
                } else {
                    return salario * 0.7;
                }
            default:
                return 0;
        }
    }

    public String getIdentidad() {
        String nombreCompleto = "Maria Jose Noreña"; // Reemplazar con tu nombre
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public String getPatron() {
        return "Patrón implementado: Estrategia (Strategy Pattern)";
    }
}