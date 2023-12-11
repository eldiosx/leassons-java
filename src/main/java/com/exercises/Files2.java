package com.exercises;

/*
 * Use FileWriter to create a new file called "numeros.txt"
 * and write the numbers 1 to 10 in it, each on a different line.
 */

import java.io.FileWriter;
import java.io.IOException;

public class Files2 {
    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Specify the file name
        String fileName = "src/main/resources/numbers.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write numbers 1 to 10 to the file, each on a different line
            for (int i = 1; i <= 10; i++) {
                writer.write(Integer.toString(i) + "\n");
            }
            System.out.println("Numbers have been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
