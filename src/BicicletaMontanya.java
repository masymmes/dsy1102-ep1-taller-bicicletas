public class BicicletaMontanya extends Bicicleta {

    private int suspensiones;

    public BicicletaMontanya(String codigo, int anioFabricacion, double peso, int suspensiones) {
        super(codigo, anioFabricacion, peso);
        setSuspensiones(suspensiones);
    }

    @Override
    public double calcularCostoMantencion() {
        double costo = 30000;
        if (suspensiones > 1) {
            costo = costo * 1.15;
        }
        return costo;
    }

    @Override
    public String mostrarInformacion() {
        return "Tipo: Bicicleta de Montaña | Código: " + getCodigo() + " | Año: " + getAnioFabricacion()
                + " | Peso: " + getPeso() + " kg | Suspensiones: " + suspensiones
                + " | Costo mantención: $" + (int) calcularCostoMantencion();
    }

    public int getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(int suspensiones) {
        if (suspensiones < 0) {
            throw new IllegalArgumentException("Las suspensiones no pueden ser negativas");
        }
        this.suspensiones = suspensiones;
    }
}