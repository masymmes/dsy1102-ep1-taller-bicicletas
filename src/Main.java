import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        try {
            BicicletaElectrica e1 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
            BicicletaElectrica e2 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
            BicicletaMontanya m1 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
            BicicletaMontanya m2 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

            e1.activarGarantiaExtendida();

            gestor.registrarBicicleta(e1);
            gestor.registrarBicicleta(e2);
            gestor.registrarBicicleta(m1);
            gestor.registrarBicicleta(m2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        buscar(gestor, "BIC-E01");

        System.out.println("\n LISTADO DE BICICLETAS ");
        gestor.listarBicicletas();

        System.out.println("\nCosto total de mantención: $" + (int) gestor.calcularCostoTotal());

        // prueba de las validaciones
        System.out.println("\nPRUEBA DE VALIDACIONES");
        try {
            BicicletaMontanya mala = new BicicletaMontanya("BIC-M03", 1990, 10.0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        menu(gestor);
    }

    public static void buscar(GestorTallerBicicletas gestor, String codigo) {
        System.out.println("\n=== BUSQUEDA POR CODIGO: \"" + codigo + "\" ===");
        ArrayList<Bicicleta> resultado = gestor.buscarPorCodigo(codigo);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron bicicletas");
        }
        for (Bicicleta b : resultado) {
            System.out.println(b.mostrarInformacion());
            System.out.println("---");
        }
    }

    public static void menu(GestorTallerBicicletas gestor) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n MENU ");
            System.out.println("1 Registrar bicicleta de montaña");
            System.out.println("2 Buscar bicicleta por codigo");
            System.out.println("3 Listar bicicletas");
            System.out.println("0 Salir");
            opcion = leerEntero("Ingrese una opcion: ");

            if (opcion == 1) {
                registrarMontanya(gestor);
            } else if (opcion == 2) {
                String codigo = leerTexto("Ingrese el codigo: ");
                buscar(gestor, codigo);
            } else if (opcion == 3) {
                gestor.listarBicicletas();
            } else if (opcion != 0) {
                System.out.println("Opcion no valida");
            }
        }
        System.out.println("Programa terminado");
    }

    public static void registrarMontanya(GestorTallerBicicletas gestor) {
        boolean listo = false;
        while (!listo) {
            try {
                String codigo = leerTexto("Codigo: ");
                int anio = leerEntero("Año de fabricacion: ");
                double peso = leerDouble("Peso (kg): ");
                int suspensiones = leerEntero("Cantidad de suspensiones: ");
                BicicletaMontanya nueva = new BicicletaMontanya(codigo, anio, peso, suspensiones);
                gestor.registrarBicicleta(nueva);
                listo = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Ingrese los datos de nuevo.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: no puede estar vacio");
            }
        }
        return texto;
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero entero");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero, por ejemplo 12.5");
            }
        }
    }
}