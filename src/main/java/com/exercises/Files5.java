package com.exercises;

/*
 * Use RandomAccessFile to position the pointer
 * at byte 50 of "file.dat" and read the next
 * 10 bytes into an array.
 */

import java.io.RandomAccessFile;
import java.io.IOException;

public class Files5 {
    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Specify the file name
        String fileName = "src/main/resources/file.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            // Set the file pointer to byte 50
            raf.seek(50);

            // Create a byte array to hold the next 10 bytes
            byte[] buffer = new byte[10];

            // Read the next 10 bytes into the buffer
            int bytesRead = raf.read(buffer);

            if (bytesRead != -1) {
                // Print or use the bytes as needed
                for (byte b : buffer) {
                    System.out.print(b + " ");
                }
            } else {
                System.out.println("End of file reached.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
