package src.co.edu.ucc.Maria_.Sistema_de_Vehiculos;

import co.edu.ucc.Maria_.Vehiculo;

public class CarroElectrico extends Vehiculo {
    public CarroElectrico(String marca, String modelo, int año) {
            super(marca, modelo, año);
            
        }
    
    public CarroElectrico() {
        super("defaultMarca", "defaultModelo", 0);
    }

        @Override
    public void encender() {
        System.out.println("Carro eléctrico encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("Carro eléctrico apagado.");
    }
}