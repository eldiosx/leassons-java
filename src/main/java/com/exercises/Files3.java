package com.exercises;

/*
 * Reads the file "numbers.txt" with FileReader
 * and displays its contents on the screen.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Files3 {
    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Specify the file name
        String fileName = "src/main/resources/numbers.txt";

        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            // Read and display each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
