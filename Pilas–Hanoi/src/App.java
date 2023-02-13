// En este programa, la función moverDisco es una función recursiva que se encarga de simular los movimientos necesarios para resolver el juego de las Torres de Hanoi. En la función main, se pide al usuario que introduzca el número de discos que se quieren utilizar, y luego se llama a la función moverDisco para realizar los movimientos necesarios para resolver el juego. Al final, se muestra en pantalla el número total de movimientos realizados

import java.util.Scanner;

public class App {
   static int contador = 0;
   static void moverDisco(int n, String origen, String intermedio, String destino) {
      if (n == 1) {
         System.out.println("Mover disco 1 desde " + origen + " hasta " + destino);
         contador++;
      } else {
         moverDisco(n - 1, origen, destino, intermedio);
         System.out.println("Mover disco " + n + " desde " + origen + " hasta " + destino);
         contador++;
         moverDisco(n - 1, intermedio, origen, destino);
      }
   }
   public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Introduce el número de discos: ");
    int n = scan.nextInt();
    moverDisco(n, "A", "B", "C");
    System.out.println("\nSe han realizado " + contador + " movimientos");
 }
}