package com.exercises;

/*
 * Write a program that asks the user for their name and age,
 * and displays a welcome message. Make sure you use variables,
 * constants, and comments in your code
 */

import java.util.Scanner;

public class General1 {

    public static void main(String[] args) {
        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Constants
        final String GREETING = "Welcome,";

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read the user's name

        // Prompt the user for their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read the user's age

        // Close the scanner to prevent resource leak
        scanner.close();

        // Display the welcome message
        System.out.println(GREETING + " " + name + "!");
        System.out.println("You are " + age + " years old.");
    }

}
