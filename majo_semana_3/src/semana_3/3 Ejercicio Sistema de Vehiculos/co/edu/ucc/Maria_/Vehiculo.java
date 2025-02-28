package co.edu.ucc.Maria_;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int año;

    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public abstract void encender();
    public abstract void apagar();

    @Override
    public String toString() {
        return "Vehículo: " + marca + " " + modelo + " (" + año + ")";
    }
}

