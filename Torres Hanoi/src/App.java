// En este código, se crean tres ArrayList para representar las tres torres. Cada torre es un ArrayList de enteros, donde cada entero representa un disco con un tamaño determinado. En la función initializeTowers, se inicializan las torres con los discos en la primera torre.

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static ArrayList<Integer>[] towers = new ArrayList[3];

    public static void main(String[] args) {
        int numDiscs = 3;
        initializeTowers(numDiscs);
        Scanner sc = new Scanner(System.in);

        while (!isGameOver()) {
            System.out.println("Current state of towers:");
            printTowers();
            System.out.println("Enter the source tower (1-3):");
            int source = sc.nextInt() - 1;
            System.out.println("Enter the destination tower (1-3):");
            int dest = sc.nextInt() - 1;
            moveDisc(source, dest);
        }
        sc.close();
        System.out.println("Congratulations! You won the game in " + numMoves + " moves.");
    }

    private static void initializeTowers(int numDiscs) {
        for (int i = 0; i < 3; i++) {
            towers[i] = new ArrayList<>();
        }

        for (int i = numDiscs; i > 0; i--) {
            towers[0].add(i);
        }
    }

    private static boolean isGameOver() {
        return towers[2].size() == numDiscs;
    }

    private static void printTowers() {
        for (int i = numDiscs - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (i < towers[j].size()) {
                    System.out.print(towers[j].get(i));
                } else {
                    System.out.print(" ");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static void moveDisc(int source, int dest) {
        int sourceTop = towers[source].get(towers[source].size() - 1);
        int destTop = towers[dest].get(towers[dest].size() - 1);

        if (sourceTop > destTop) {
            System.out.println("Invalid move! You can only move a smaller disc onto a larger disc.");
            return;
        }

        towers[dest].add(sourceTop);
        towers[source].remove(towers[source].size() - 1);
        numMoves++;
    }

    private static int numMoves = 0;
}