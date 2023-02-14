
// El programa permite al usuario ingresar el número de discos que desea usar. Luego, se inicializa el juego llamando a la función inicializarTorres que crea un ArrayList para cada una de las torres y agrega los discos en orden decreciente a la primera torre. La función jugar permite al usuario jugar por turnos
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends ArrayList {
    private static int numDiscos;
    private static ArrayList<Integer>[] torres;
    private static int turnos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduce el numero de discos: ");
        try {
            numDiscos = scanner.nextInt();
            while (numDiscos < 1) {
                System.out.println("Error: el numero de discos debe ser mayor que 0.");
                System.out.print("Introduce el numero de discos: ");
                numDiscos = scanner.nextInt();
            }
            inicializarTorres();
            jugar();
        } catch (InputMismatchException e) {
            System.out.println("Error: el numero de discos debe ser un numero entero.");
        }
        scanner.close();
    }

    @SuppressWarnings("unchecked")
    private static void inicializarTorres() {
        torres = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new ArrayList<Integer>();
        }
        for (int i = numDiscos; i >= 1; i--) {
            torres[0].add(i);
        }
        turnos = 1;
    }

    private static void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (torres[2].size() != numDiscos) {
            System.out.println("============================");
            System.out.println("---Turno " + turnos + "---");
            System.out.println("Torre A: " + torres[0]);
            System.out.println("Torre B: " + torres[1]);
            System.out.println("Torre C: " + torres[2]);
            System.out.println("---Mover disco---");
            System.out.print("Desde torre (A/B/C): ");
            String origen = scanner.next().toUpperCase(); //Se usa el método toUpperCase() para permitir que el usuario ingrese tanto mayúsculas como minúsculas para las letras de la torre.
            System.out.print("Hacia torre (A/B/C): ");
            String destino = scanner.next().toUpperCase();
            try {
                moverDisco(origen.charAt(0) - 'A', destino.charAt(0) - 'A');
                turnos++;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: la torre debe ser A, B o C.");
            }
        }
        scanner.close();
        System.out.println("Felicidades, has ganado en " + turnos + " movimientos!");
    }

    private static void moverDisco(int origen, int destino) {
        if (origen < 0 || origen > 2 || destino < 0 || destino > 2) {
            System.out.println("Error: las torres deben estar en el rango de 1 a 3.");
            return;
        }
        if (!torres[origen].isEmpty()) {
            int disco = torres[origen].get(torres[origen].size() - 1);
            if (torres[destino].isEmpty() || torres[destino].get(torres[destino].size() - 1) > disco) {
                torres[destino].add(torres[origen].remove(torres[origen].size() - 1));
            }
        }
    }
}

// AÑADIR
// Uso de constantes: Puedes declarar constantes para los números 3 y 1 que se
// utilizan varias veces en el código en lugar de escribirlos directamente.

// Refactorización de métodos: El método jugar es bastante largo y puede ser
// refactorizado en métodos más pequeños y concisos para hacerlo más legible y
// fácil de mantener.

// Validación de entrada: Actualmente, el programa no valida la entrada del
// usuario, por lo que si el usuario ingresa un número fuera del rango de 1 a 3,
// el programa generará un error. Se deben agregar controles para asegurarse de
// que el usuario ingrese un número válido. HECHO

// Eliminación de código redundante: En el método inicializarTorres, se utiliza
// el mismo código para inicializar cada uno de los tres elementos del arreglo
// torres. Esto se puede refactorizar en un bucle para evitar la redundancia y
// hacer que el código sea más eficiente.

// Mejora de la impresión: Puedes mejorar la forma en que se imprimen los
// estados de las torres para hacerlo más fácil de entender para el usuario.

// Try and Catch para que el usuario no meta una letra y bloquee el programa.
// HECHO

// Escribir movimientos en un archivo.txt.