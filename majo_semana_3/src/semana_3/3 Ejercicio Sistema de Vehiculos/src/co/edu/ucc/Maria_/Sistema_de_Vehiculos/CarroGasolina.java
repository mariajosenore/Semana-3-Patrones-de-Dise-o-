package src.co.edu.ucc.Maria_.Sistema_de_Vehiculos;

import co.edu.ucc.Maria_.Vehiculo;


public class CarroGasolina extends Vehiculo {
    public CarroGasolina(String marca, String modelo, int año) {
        super(marca, modelo, año);
    }

    @Override
    public void encender() {
        System.out.println("Carro de gasolina encendido. ¡Ruge el motor!");
    }

    @Override
    public void apagar() {
        System.out.println("Carro de gasolina apagado.");
    }
}