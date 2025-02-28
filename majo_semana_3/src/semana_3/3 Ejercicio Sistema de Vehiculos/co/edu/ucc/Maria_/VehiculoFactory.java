package co.edu.ucc.Maria_;

import src.co.edu.ucc.Maria_.Sistema_de_Vehiculos.CarroElectrico;
import src.co.edu.ucc.Maria_.Sistema_de_Vehiculos.CarroGasolina;

public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo, String marca, String modelo, int año) throws VehiculoNoValidoException {
        if (tipo.equalsIgnoreCase("electrico")) {
            return new CarroElectrico();
        } else if (tipo.equalsIgnoreCase("gasolina")) {
            return new CarroGasolina(marca, modelo, año);
        } else {
            throw new VehiculoNoValidoException("Tipo de vehículo no válido: " + tipo);
        }
    }
}