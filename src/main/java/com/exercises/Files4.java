package com.exercises;

/*
 * Read the first 100 bytes of the file "image.jpg"
 * using FileInputStream and save them in a byte array.
 */

import java.io.FileInputStream;
import java.io.IOException;

public class Files4 {
    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Specify the file name
        String fileName = "src/main/resources/image.jpg";

        // Define the buffer size to read
        int bufferSize = 100;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] buffer = new byte[bufferSize];

            // Read the first 100 bytes into the buffer
            int bytesRead = fis.read(buffer, 0, bufferSize);

            if (bytesRead != -1) {
                // Create a new byte array with the exact number of bytes read
                byte[] result = new byte[bytesRead];
                System.arraycopy(buffer, 0, result, 0, bytesRead);

                // Print or use the bytes as needed
                for (byte b : result) {
                    System.out.print(b + " ");
                }
            } else {
                System.out.println("End of file reached before reading 100 bytes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
