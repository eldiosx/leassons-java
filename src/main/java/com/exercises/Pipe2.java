package com.exercises;

/*
 * Develop a program called "Order" that reads numbers from standard input,
 * stores them in an array, sorts the numbers with a sorting algorithm
 * (bubble, quicksort, etc.). Display sorted array on standard output.
*/

import java.util.Scanner;

public class Pipe2 {

    public static void main(String[] args) {

        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of elements
        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        // Create an array to store the numbers
        int[] numbers = new int[numElements];

        // Read the numbers from the user
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Sort the array using the bubble sort algorithm & display it
        bubbleSort(numbers);
        System.out.println("Sorted Array:");
        for (int i = 0; i < numElements; i++) {
            System.out.print(numbers[i] + " ");
        }

        // Stop the scanner
        scanner.close();
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Swap the arrs
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

}