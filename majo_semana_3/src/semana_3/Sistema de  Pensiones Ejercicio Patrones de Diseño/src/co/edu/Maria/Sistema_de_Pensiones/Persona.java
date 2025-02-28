package src.co.edu.Maria.Sistema_de_Pensiones;

public class Persona {
    private String ley;
    private double salario;

    public Persona(String ley, double salario) {
        this.ley = ley;
        this.salario = salario;
    }

    public String getLey() {
        return ley;
    }

    public double getSalario() {
        return salario;
    }
}