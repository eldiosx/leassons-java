package com.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Files8 {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            switch (1) {
                case 1:
                    // Step 1: Create a text file called "data.txt"
                    boolean fileCreated = file.createNewFile();
                    if (fileCreated) {
                        System.out.println("File created successfully.");
                    } else {
                        System.out.println("File already exists.");
                    }
                    break;

                case 2:
                    // Step 2: Write 5 lines of made-up text
                    FileWriter writer = new FileWriter(file);
                    writer.write("Line 1: This is some text.\n");
                    writer.write("Line 2: Another line of text.\n");
                    writer.write("Line 3: More text here.\n");
                    writer.write("Line 4: Even more text.\n");
                    writer.write("Line 5: Final line.\n");
                    writer.close();
                    System.out.println("File written successfully.");
                    break;

                case 3:
                    // Step 3: Read and print the content
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    reader.close();
                    break;

                case 4:
                    // Step 4: Count total characters
                    FileReader charReader = new FileReader(file);
                    int charCount = 0;
                    int charData;
                    while ((charData = charReader.read()) != -1) {
                        charCount++;
                    }
                    charReader.close();
                    System.out.println("Total characters: " + charCount);
                    break;

                case 5:
                    // Step 5: Count occurrences of a word
                    FileReader wordReader = new FileReader(file);
                    BufferedReader wordBufferedReader = new BufferedReader(wordReader);
                    String wordToCount = "text";
                    int wordCount = 0;
                    while ((line = wordBufferedReader.readLine()) != null) {
                        if (line.contains(wordToCount)) {
                            wordCount++;
                        }
                    }
                    wordBufferedReader.close();
                    wordReader.close();
                    System.out.println("Occurrences of '" + wordToCount + "': " + wordCount);
                    break;

                case 6:
                    // Step 6: Read, replace a word, and rewrite
                    FileReader replaceReader = new FileReader(file);
                    BufferedReader replaceBufferedReader = new BufferedReader(replaceReader);
                    String updatedContent = "";
                    String replaceWord = "text";
                    String replacement = "content";
                    while ((line = replaceBufferedReader.readLine()) != null) {
                        updatedContent += line.replaceAll(replaceWord, replacement) + "\n";
                    }
                    replaceBufferedReader.close();
                    replaceReader.close();

                    FileWriter replaceWriter = new FileWriter(file);
                    replaceWriter.write(updatedContent);
                    replaceWriter.close();
                    break;

                case 7:
                    // Step 7: Copy to "copy.txt"
                    File copyFile = new File("copy.txt");
                    FileReader copyReader = new FileReader(file);
                    BufferedReader copyBufferedReader = new BufferedReader(copyReader);
                    FileWriter copyWriter = new FileWriter(copyFile);
                    while ((line = copyBufferedReader.readLine()) != null) {
                        copyWriter.write(line + "\n");
                    }
                    copyBufferedReader.close();
                    copyReader.close();
                    copyWriter.close();
                    break;

                case 8:
                    // Step 8: Append from "data.txt" to "copy.txt"
                    FileWriter appendWriter = new FileWriter("copy.txt", true);
                    FileReader appendReader = new FileReader(file);
                    BufferedReader appendBufferedReader = new BufferedReader(appendReader);
                    while ((line = appendBufferedReader.readLine()) != null) {
                        appendWriter.write(line + "\n");
                    }
                    appendBufferedReader.close();
                    appendReader.close();
                    appendWriter.close();
                    break;

                case 9:
                    // Step 9: Read, convert to uppercase, and write to "copy.txt"
                    FileReader uppercaseReader = new FileReader("copy.txt");
                    BufferedReader uppercaseBufferedReader = new BufferedReader(uppercaseReader);
                    String uppercaseContent = "";
                    while ((line = uppercaseBufferedReader.readLine()) != null) {
                        uppercaseContent += line.toUpperCase() + "\n";
                    }
                    uppercaseBufferedReader.close();
                    uppercaseReader.close();

                    FileWriter uppercaseWriter = new FileWriter("copy.txt");
                    uppercaseWriter.write(uppercaseContent);
                    uppercaseWriter.close();
                    break;

                case 10:
                    // Step 10: Read, remove whitespace, and write to "copia.txt"
                    FileReader whitespaceReader = new FileReader("copy.txt");
                    BufferedReader whitespaceBufferedReader = new BufferedReader(whitespaceReader);
                    String noWhitespaceContent = "";
                    while ((line = whitespaceBufferedReader.readLine()) != null) {
                        noWhitespaceContent += line.replaceAll("\\s", "") + "\n";
                    }
                    whitespaceBufferedReader.close();
                    whitespaceReader.close();

                    FileWriter noWhitespaceWriter = new FileWriter("copia.txt");
                    noWhitespaceWriter.write(noWhitespaceContent);
                    noWhitespaceWriter.close();
                    break;

                case 11:
                    // Step 11: Read lines in reverse and write to "copy.txt"
                    FileReader reverseReader = new FileReader("copy.txt");
                    BufferedReader reverseBufferedReader = new BufferedReader(reverseReader);
                    List<String> linesInReverse = new ArrayList<>();
                    while ((line = reverseBufferedReader.readLine()) != null) {
                        linesInReverse.add(line);
                    }
                    reverseBufferedReader.close();
                    reverseReader.close();

                    FileWriter reverseWriter = new FileWriter("copy.txt");
                    for (int i = linesInReverse.size() - 1; i >= 0; i--) {
                        reverseWriter.write(linesInReverse.get(i) + "\n");
                    }
                    reverseWriter.close();
                    break;

                case 12:
                    // Step 12: Delete "data.txt"
                    if (file.delete()) {
                        System.out.println("File deleted successfully.");
                    } else {
                        System.out.println("Failed to delete the file.");
                    }
                    break;

                case 13:
                    // Step 13: Check if "data.txt" exists
                    if (file.exists()) {
                        System.out.println("File 'data.txt' exists.");
                    } else {
                        System.out.println("File 'data.txt' does not exist.");
                    }
                    break;

                case 14:
                    // Step 14: Create "exercises" directory and move "copia.txt"
                    File exercisesDir = new File("exercises");
                    if (exercisesDir.mkdir()) {
                        File copiaFile = new File("copia.txt");
                        File newLocation = new File(exercisesDir, "copia.txt");
                        if (copiaFile.renameTo(newLocation)) {
                            System.out.println("File moved successfully.");
                        } else {
                            System.out.println("Failed to move the file.");
                        }
                    } else {
                        System.out.println("Failed to create the 'exercises' directory.");
                    }
                    break;

                case 15:
                    // Step 15: Get last modified date and size of "copy.txt"
                    File copyTxtFile = new File("copy.txt");
                    long lastModified = copyTxtFile.lastModified();
                    long fileSizeInBytes = copyTxtFile.length();

                    System.out.println("Last Modified Date: " + new Date(lastModified));
                    System.out.println("File Size (in bytes): " + fileSizeInBytes);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
                }
            }
        }
    }
}
