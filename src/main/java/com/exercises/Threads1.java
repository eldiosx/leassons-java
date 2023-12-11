package com.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Threads1 {
    public static void main(String[] args) {
        // Clear console (Unix-like) :3
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        if (args.length != 2) {
            System.out.println(
                    "Incorrect usage. You must provide the number of reports and the output file name.");
            return;
        }

        int numReports = Integer.parseInt(args[0]);
        String fileName = args[1];

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Random random = new Random();

            for (int i = 0; i < numReports; i++) {
                String report = generateRandomReport(random);
                writer.write(report);
                writer.newLine();
            }

            writer.close();
            System.out.println("Generated " + numReports + " reports in the file " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static String generateRandomReport(Random random) {
        String name = "Player" + random.nextInt(100);
        String statistics = "Statistics: " + random.nextDouble();
        return name + " - " + statistics;
    }
}
