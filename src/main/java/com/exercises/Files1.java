package com.exercises;

/*
 * Instantiates a File object for the file "data.txt"
 * and prints its absolute path on the screen. 
 */

import java.io.File;

public class Files1 {

    public static void main(String[] args) {

        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Specify the file name or path
        String fileName = "src/main/resources/data.txt";

        // Create a File object with the specified file name
        File file = new File(fileName);

        // Check if the file exists
        if (file.exists()) {
            // Get and print the absolute path of the file
            String absolutePath = file.getAbsolutePath();
            System.out.println("Absolute Path: " + absolutePath);
        } else {
            System.out.println("The file does not exist.");
        }
    }
}

