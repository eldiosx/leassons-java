package com.exercises;

/*
 * Create a BufferedReader to improve
 * the performance of reading the "big.txt" file.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Files6 {
    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Specify the file name
        String fileName = "src/main/resources/big.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Process each line of the file here
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
