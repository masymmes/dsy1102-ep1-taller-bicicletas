import java.util.ArrayList;

public class GestorTallerBicicletas {

    // uso ArrayList porque no se cuantas bicicletas se van a registrar
    private ArrayList<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        bicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName()
                + ") registrada correctamente.");
    }

    public ArrayList<Bicicleta> buscarPorCodigo(String codigo) {
        ArrayList<Bicicleta> encontradas = new ArrayList<>();
        for (Bicicleta b : bicicletas) {
            if (b.getCodigo().equalsIgnoreCase(codigo)) {
                encontradas.add(b);
            }
        }
        return encontradas;
    }

    // sobrecarga: busca por codigo y ademas por año
    public ArrayList<Bicicleta> buscarPorCodigo(String codigo, int anio) {
        ArrayList<Bicicleta> encontradas = new ArrayList<>();
        for (Bicicleta b : buscarPorCodigo(codigo)) {
            if (b.getAnioFabricacion() == anio) {
                encontradas.add(b);
            }
        }
        return encontradas;
    }

    public void listarBicicletas() {
        for (Bicicleta b : bicicletas) {
            System.out.println(b.toString());
        }
    }

    // polimorfismo: cada bicicleta calcula su propio costo
    public double calcularCostoTotal() {
        double total = 0;
        for (Bicicleta b : bicicletas) {
            total = total + b.calcularCostoMantencion();
        }
        return total;
    }

    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }
}