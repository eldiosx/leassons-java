import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static int numDiscos;
    private static ArrayList<Integer>[] torres;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de discos: ");
        numDiscos = scanner.nextInt();
        inicializarTorres();
        jugar();
        scanner.close();
    }

    private static void inicializarTorres() {
        torres = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new ArrayList<Integer>();
        }
        for (int i = numDiscos; i >= 1; i--) {
            torres[0].add(i);
        }
    }

    private static void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (torres[2].size() != numDiscos) {
            System.out.println("Torre 1: " + torres[0]);
            System.out.println("Torre 2: " + torres[1]);
            System.out.println("Torre 3: " + torres[2]);
            System.out.print("Mover disco desde (1-3): ");
            int origen = scanner.nextInt() - 1;
            System.out.print("Hacia torre (1-3): ");
            int destino = scanner.nextInt() - 1;
            moverDisco(origen, destino);
        }
        System.out.println("Felicidades, has ganado en " + (numDiscos - 1) + " movimientos!");
        scanner.close();
    }

    private static void moverDisco(int origen, int destino) {
        if (!torres[origen].isEmpty()) {
            int disco = torres[origen].get(torres[origen].size() - 1);
            if (torres[destino].isEmpty() || torres[destino].get(torres[destino].size() - 1) > disco) {
                torres[destino].add(torres[origen].remove(torres[origen].size() - 1));
            }
        }
    }
}