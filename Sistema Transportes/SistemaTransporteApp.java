public class SistemaTransporteApp {
    public static void main(String[] args) {
        List<Ruta> rutas = new ArrayList<>();

        // Rutas iniciales del sistema (como las tienes)

        rutas.add(RutaFactory.crearRuta(new RutaBuilder()
            .setNombre("Ruta Central")
            .setTipo(TipoRuta.URBANA)
            .setNumeroParadas(15)
            .setKilometraje(25.7)
            .setCondicionesViales("Buena")
            .setTipoVehiculo("Bus urbano")
            .setRutaContingencia("Desvío por obras en calle 5")
            .setLimitePasajeros(50)
            .setZonaCoberturaExtendida(true)));

        rutas.add(RutaFactory.crearRuta(new RutaBuilder()
            .setNombre("Ruta Cauca-Popayán")
            .setTipo(TipoRuta.INTERMUNICIPAL)
            .setNumeroParadas(8)
            .setKilometraje(70.5)
            .setCondicionesViales("Variable por lluvias")
            .setTipoVehiculo("Bus intermunicipal")
            .setRutaContingencia("Camino alternativo vía La Paila")
            .setLimitePasajeros(40)
            .setZonaCoberturaExtendida(false)));

        rutas.add(RutaFactory.crearRuta(new RutaBuilder()
            .setNombre("Ruta Panorámica")
            .setTipo(TipoRuta.TURISTICA)
            .setNumeroParadas(10)
            .setKilometraje(30.0)
            .setCondicionesViales("Excelente")
            .setTipoVehiculo("Microbús turístico")
            .setLimitePasajeros(30)
            .setZonaCoberturaExtendida(true)));

        // ... (agrega las otras rutas como las tienes)

        // Mostrar detalles de todas las rutas
        for (Ruta ruta : rutas) {
            ruta.mostrarDetalles();
        }

        // ====== INTEGRACIÓN GPS CON ADAPTER + OBSERVER ======

        // Instanciar dispositivos GPS originales
        GarminGPS garmin = new GarminGPS();
        HuaweiGPS huawei = new HuaweiGPS();
        TomTomGPS tomtom = new TomTomGPS();

        // Crear adaptadores
        IGPSBus gpsGarmin = new GarminAdapter(garmin);
        IGPSBus gpsHuawei = new HuaweiAdapter(huawei);
        IGPSBus gpsTomTom = new TomTomAdapter(tomtom);

        // Crear buses con diferentes GPS
        Bus bus1 = new Bus("Bus1", gpsGarmin);
        Bus bus2 = new Bus("Bus2", gpsHuawei);
        Bus bus3 = new Bus("Bus3", gpsTomTom);

        // Crear observadores
        Observador panel = new PanelLlegadas();
        Observador app = new AplicacionMovil();

        // Registrar observadores a buses
        bus1.agregarObservador(panel);
        bus1.agregarObservador(app);

        bus2.agregarObservador(panel);

        bus3.agregarObservador(app);

        // Actualizar GPS y notificar observadores
        bus1.actualizarGPS();
        bus2.actualizarGPS();
        bus3.actualizarGPS();
    }
}
