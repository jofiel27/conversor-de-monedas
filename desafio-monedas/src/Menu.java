import java.util.Scanner;

public class Menu {
    private final CurrencyConverter converter;

    public Menu() {
        this.converter = new CurrencyConverter();
    }

    public void iniciar() {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        while (opcion != 7) {
            mostrarOpciones();
            opcion = teclado.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese la cantidad a convertir:");
                int monto = teclado.nextInt();
                converter.convertir(opcion, monto);
            } else if (opcion == 7) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarOpciones() {
        System.out.println("********************************************");
        System.out.println("----------Convertidor de Monedas-------------");
        System.out.println("1) Dolar a Pesos Argentinos");
        System.out.println("2) Pesos Argentinos a Dolar");
        System.out.println("3) Dolar a Real Brasileño");
        System.out.println("4) Real Brasileño a Dolar");
        System.out.println("5) Dolar a Euro");
        System.out.println("6) Euro a Dolar");
        System.out.println("7) Salir");
        System.out.println("********************************************");
    }
}
