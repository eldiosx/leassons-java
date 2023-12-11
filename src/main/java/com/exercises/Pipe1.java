package com.exercises;

/*
 * Develop a program called "RandomGenerator"
 * that generates 40 random numbers between 0 - 100
 * and displays the numbers on standard output.
*/

import java.util.Random;

public class Pipe1 {

    public static void main(String[] args) {

        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Random random = new Random();

        // Generate and display 40 random numbers between 0 and 100
        for (int i = 0; i < 40; i++) {
            int randomNumber = random.nextInt(101);
            System.out.println("Random Number " + (i + 1) + ": " + randomNumber);
        }
    }

}