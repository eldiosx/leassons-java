import java.util.Scanner;

public class App {
    private static int numDiscos;
    private static int numMovimientos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de discos: ");
        numDiscos = scanner.nextInt();
        moverDiscos(numDiscos, 1, 3, 2);
        System.out.println("Número total de movimientos: " + numMovimientos);
        scanner.close();
    }

    private static void moverDiscos(int n, int origen, int destino, int auxiliar) {
        if (n == 1) {
            numMovimientos++;
            System.out.println("Mover disco " + n + " desde torre " + origen + " hasta torre " + destino);
        } else {
            moverDiscos(n - 1, origen, auxiliar, destino);
            numMovimientos++;
            System.out.println("Mover disco " + n + " desde torre " + origen + " hasta torre " + destino);
            moverDiscos(n - 1, auxiliar, destino, origen);
        }

    }
}
