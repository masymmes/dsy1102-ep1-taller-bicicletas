public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    private int autonomia;
    private boolean bateriaCertificada;
    private boolean garantiaExtendida;

    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomia,
                              boolean bateriaCertificada, boolean garantiaExtendida) {
        super(codigo, anioFabricacion, peso);
        setAutonomia(autonomia);
        setBateriaCertificada(bateriaCertificada);
        setGarantiaExtendida(garantiaExtendida);
    }

    // sobrecarga del constructor: se crea sin garantia extendida
    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomia,
                              boolean bateriaCertificada) {
        this(codigo, anioFabricacion, peso, autonomia, bateriaCertificada, false);
    }

    @Override
    public double calcularCostoMantencion() {
        double costo = 45000;
        if (!bateriaCertificada) {
            costo = costo * 1.25;
        }
        return costo;
    }

    @Override
    public String mostrarInformacion() {
        String certificada = "No";
        if (bateriaCertificada) {
            certificada = "Si";
        }
        String garantia = "No";
        if (garantiaExtendida) {
            garantia = "Si";
        }
        return "Tipo: Bicicleta Eléctrica | Código: " + getCodigo() + " | Año: " + getAnioFabricacion()
                + " | Peso: " + getPeso() + " kg | Autonomia: " + autonomia + " km | Batería certificada: "
                + certificada + "\n  Garantia extendida: " + garantia
                + " | Costo mantención: $" + (int) calcularCostoMantencion();
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendida;
    }

    @Override
    public void activarGarantiaExtendida() {
        garantiaExtendida = true;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        if (autonomia <= 0) {
            throw new IllegalArgumentException("La autonomia debe ser mayor a 0");
        }
        this.autonomia = autonomia;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    public boolean isGarantiaExtendida() {
        return garantiaExtendida;
    }

    public void setGarantiaExtendida(boolean garantiaExtendida) {
        this.garantiaExtendida = garantiaExtendida;
    }
}