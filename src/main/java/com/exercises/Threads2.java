package com.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threads2 {
    public static void main(String[] args) {
        // Clear console command for Unix-like systems
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (args.length != 1) {
            System.err.println("Incorrect usage. You must provide the output file name.");
            System.exit(1);
        }

        String fileName = args[0];
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 10; i <= 100; i += 10) {
                executor.execute(new LanguageWorker(writer, i));
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println(
                    "All instances have finished generating sets in the file " + fileName);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Worker class responsible for generating and writing sets
    private static class LanguageWorker implements Runnable {
        private final BufferedWriter writer;
        private final int numSets;

        public LanguageWorker(BufferedWriter writer, int numSets) {
            this.writer = writer;
            this.numSets = numSets;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < numSets; i++) {
                    String set = generateRandomSet();
                    writer.write(set);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Generates a random set content
        private String generateRandomSet() {
            // Here, you can generate the content of each set randomly
            // You can use methods similar to Part 1 to generate random content
            return "Random Set: " + numSets;
        }
    }
}
