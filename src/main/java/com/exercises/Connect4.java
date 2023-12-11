package connect4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Connect4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[6][7];

        // Iniciar array de datos.
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = '⌗';
            }
        }

        int turn = 1;
        char player = '➊';
        boolean win = false;

        // Contador de turnos.
        while (!win && turn <= 42) {

            boolean canPlay;
            int play;
            do {
                display(board);

                System.out.print("Jugador " + player + ", elige una columna (0-6): ");
                try {
                    play = sc.nextInt();
                    // Si la jugada se puede realizar...
                    canPlay = validate(play, board);
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número del 0 al 6.");
                    sc.nextLine(); // Consumir el token no válido
                    canPlay = false;
                    play = -1; // Valor no válido para evitar que se actualiza el tablero
                }

            } while (!canPlay);

            // drop the checker
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][play] == '⌗') {
                    board[row][play] = player;
                    break;
                }
            }

            // Comprobar si hay un ganador.
            win = iswin(player, board);

            // Cambio de jugadores.
            if (player == '➊') {
                player = '➁';
            } else {
                player = '➊';
            }

            turn++;
        }
        display(board);

        if (win) {
            if (player == '➊') {
                System.out.println("Fin del juego - Negro gana");
            } else {
                System.out.println("Fin del juego - Blanco gana");
            }
        } else {
            System.out.println("Fin del juego - Empate");
        }
        sc.close();
    }

    public static void display(char[][] board) {
        System.out.println("\n——————————————————");
        for (int row = 0; row < board.length; row++) {
            System.out.print("⎟");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
                System.out.print("⎟");
            }
            System.out.println();
            System.out.println("——————————————————");
        }
        System.out.println("  0 1 2 3 4 5 6");
        System.out.println();
    }

    public static boolean validate(int column, char[][] board) {
        // Comprobar si la columna existe.
        if (column < 0 || column >= board[0].length) {
            System.out.println("Entrada no válida. Por favor, introduce un número del 0 al 6.");
            return false;
        }

        // Comprobar si la columna está llena.
        if (board[0][column] != '⌗') {
            System.out.println("Columna llena. Por favor, elige otra columna.");
            return false;
        }

        return true;
	}

	public static boolean iswin(char player, char[][] board) {
		// Comprobar si se conectan 4 horizontalmente.
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col] == player && board[row][col + 1] == player && board[row][col + 2] == player
						&& board[row][col + 3] == player) {
					return true;
				}
			}
		}
		// Comprobar si se conectan 4 verticalmente.
		for (int row = 0; row < board.length - 3; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == player && board[row + 1][col] == player && board[row + 2][col] == player
						&& board[row + 3][col] == player) {
					return true;
				}
			}
		}
		// Comprobar si se conectan 4 diagonalmente hacia arriba.
		for (int row = 3; row < board.length; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col] == player && board[row - 1][col + 1] == player && board[row - 2][col + 2] == player
						&& board[row - 3][col + 3] == player) {
					return true;
				}
			}
		}
		// Comprobar si se conectan 4 diagonalmente haczia abajo.
		for (int row = 0; row < board.length - 3; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col] == player && board[row + 1][col + 1] == player && board[row + 2][col + 2] == player
						&& board[row + 3][col + 3] == player) {
					return true;
				}
			}
		}
		return false;
	}
}
