/*
 * Diferencias entre Java (POO) y otros paradigmas:
 *
 * - En Java todo se organiza en clases y objetos que tienen atributos y metodos.
 *   En la programacion estructurada (como C) se usan funciones separadas de los datos.
 *
 * - Java tiene tipado estatico: cada variable se declara con su tipo (int, double, String)
 *   y despues no se puede cambiar. En Python por ejemplo no se pone el tipo y una
 *   variable puede guardar un numero y despues un texto.
 *
 * - Java primero se compila (javac crea los .class) y despues lo ejecuta la JVM.
 *   Python es interpretado, se va ejecutando linea por linea sin compilar antes.
 *
 * - Por el tipado estatico, si me equivoco en un tipo (ej: le paso un texto a un int)
 *   el compilador me avisa antes de ejecutar el programa. En un lenguaje dinamico ese
 *   error recien aparece cuando el programa ya esta corriendo.
 */
public abstract class Bicicleta {

    private String codigo;
    private int anioFabricacion;
    private double peso;

    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    // cada tipo de bicicleta calcula su costo distinto
    public abstract double calcularCostoMantencion();

    // cada tipo muestra su informacion completa
    public abstract String mostrarInformacion();

    // sobrecarga: calcula el costo con un descuento en porcentaje
    public double calcularCostoMantencion(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        return calcularCostoMantencion() - (calcularCostoMantencion() * descuento / 100);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede ser nulo ni vacio");
        }
        this.codigo = codigo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año debe estar entre 2000 y 2026");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}