package com.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Files7 {
    public static void main(String[] args) {
        try {
            // Unix type clear console :3
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Create a text file called "data.txt" with the File class and createNewFile()
            // method.
            File file = new File("src/main/resources/data.txt");
            file.createNewFile();

            // Open the file in write mode with FileWriter and write 5 lines of made-up
            // text.
            FileWriter writer = new FileWriter(file);
            writer.write("Line 1: This is some text.\n");
            writer.write("Line 2: Here's another line of text.\n");
            writer.write("Line 3: More text goes here.\n");
            writer.write("Line 4: Yet another line.\n");
            writer.write("Line 5: Final line of text.\n");
            writer.close();

            // Open the file in reading mode with FileReader and BufferedReader.
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // Read line by line and print the content via console with println().
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Open the file in reading mode and go through character by character counting
            // the total characters.
            reader = new FileReader(file);
            int characterCount = 0;
            int c = 0;
            while ((c = reader.read()) != -1) {
                characterCount++;
            }
            System.out.println(c);
            reader.close();
            System.out.println("Total characters: " + characterCount);

            // Open again in reading mode, read line by line and use contains() to count
            // occurrences of a word.
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String searchWord = "text";
            int wordCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    wordCount++;
                }
            }
            reader.close();
            System.out.println("Occurrences of '" + searchWord + "': " + wordCount);

            // Open in read and write mode using FileReader and FileWriter.
            File modifiedFile = new File("src/main/resources/modified_data.txt");
            reader = new FileReader(file);
            FileWriter writer2 = new FileWriter(modifiedFile);
            bufferedReader = new BufferedReader(reader);
            String replacementWord = "changed";
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("text", replacementWord);
                writer2.write(line + "\n");
            }
            reader.close();
            writer2.close();

            // Open the original file in reading and copy line by line into a new file
            // "copy.txt" using FileWriter.
            FileWriter copyWriter = new FileWriter("src/main/resources/copy.txt");
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            while ((line = bufferedReader.readLine()) != null) {
                copyWriter.write(line + "\n");
            }
            reader.close();
            copyWriter.close();

            // Open "data.txt" and "copy.txt" in append mode.
            FileWriter dataAppendWriter = new FileWriter("src/main/resources/data.txt", true);
            FileReader copyReader = new FileReader("src/main/resources/copy.txt");
            bufferedReader = new BufferedReader(copyReader);
            String appendLine;
            while ((appendLine = bufferedReader.readLine()) != null) {
                dataAppendWriter.write(appendLine + "\n");
            }
            dataAppendWriter.close();
            copyReader.close();

            // Open "copy.txt" in read/write, read lines, convert to uppercase, and write
            // again.
            FileReader copyFileReader = new FileReader("src/main/resources/copy.txt");
            bufferedReader = new BufferedReader(copyFileReader);
            List<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.toUpperCase());
            }
            copyFileReader.close();
            FileWriter copyFileWriter = new FileWriter("src/main/resources/copy.txt");
            for (String updatedLine : lines) {
                copyFileWriter.write(updatedLine + "\n");
            }
            copyFileWriter.close();

            // Open "copy.txt" in read/write, read lines, remove whitespace, and write
            // again.
            FileReader copy2FileReader = new FileReader("src/main/resources/copy.txt");
            bufferedReader = new BufferedReader(copyFileReader);
            List<String> copyLines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                copyLines.add(line.replaceAll("\\s", ""));
            }
            copy2FileReader.close();
            FileWriter copy2FileWriter = new FileWriter("src/main/resources/copy.txt");
            for (String updatedLine : copyLines) {
                copyFileWriter.write(updatedLine + "\n");
            }
            copy2FileWriter.close();

            // Open "copy.txt" in read/write, read lines in list, reverse list, and write
            // again.
            FileReader reverseFileReader = new FileReader("src/main/resources/copy.txt");
            bufferedReader = new BufferedReader(reverseFileReader);
            List<String> reverseLines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                reverseLines.add(line);
            }
            reverseFileReader.close();
            Collections.reverse(reverseLines);
            FileWriter reverseFileWriter = new FileWriter("src/main/resources/copy.txt");
            for (String reversedLine : reverseLines) {
                reverseFileWriter.write(reversedLine + "\n");
            }
            reverseFileWriter.close();

            // Create File object for "data.txt" and delete with delete().
            File dataFile = new File("src/main/resources/data.txt");
            if (dataFile.delete()) {
                System.out.println("File 'data.txt' deleted.");
            } else {
                System.out.println("Failed to delete 'data.txt'.");
            }

            // Check if "data.txt" exists after removing it with exists().
            if (dataFile.exists()) {
                System.out.println("'data.txt' still exists.");
            } else {
                System.out.println("'data.txt' does not exist.");
            }

            // Create "exercises" directory with mkdir().
            File exercisesDir = new File("src/main/resources/exercises");
            exercisesDir.mkdir();

            // Move "copy.txt" to the "exercises" directory with renameTo().
            File copyFile = new File("src/main/resources/copy.txt");
            File newLocation = new File(exercisesDir, copyFile.getName());
            if (copyFile.renameTo(newLocation)) {
                System.out.println("Moved 'copy.txt' to 'exercises' directory.");
            } else {
                System.out.println("Failed to move 'copy.txt'.");
            }

            // Get last modified date and size in bytes of "copy.txt" and display.
            File copyTxtFile = new File("src/main/resources/copy.txt");
            long lastModified = copyTxtFile.lastModified();
            long fileSize = copyTxtFile.length();
            System.out.println("Last Modified Date: " + lastModified);
            System.out.println("File Size (bytes): " + fileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
