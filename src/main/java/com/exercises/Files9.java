package com.exercises;

/*
Make ONE Java application that meets the following requirements and Capture and manage any possible exceptions that may occur.
 */

import java.io.*;

public class Files9 {
    public static void main(String[] args) throws Exception {
        // Unix type clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // 1. Using the File class, create a subdirectory called "my_files" in the
        // proyect path if it does not previously exist.
        // I will save it in variables to reuse the easier routes later
        try {
            String directoryPath = "src/main/resources/my_files";
            String dataFilePath = directoryPath + "/data.txt";
            String copyFilePath = directoryPath + "/copy.txt";

            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("Directory created");
            }

            // 2. Inside the directory my_files, create a plain text file called
            // "data.txt" with the following content if it does not previously exist:
            File dataFile = new File(dataFilePath);
            if (!dataFile.exists()) {
                FileWriter fileWriter = new FileWriter(dataFile);
                String content = "Era un muchacho de rostro encantador, tal vez de dieciséis años cuando fue convertido, con esa\n"
                        + "piel lisa que tiene algunos donceles y facciones muy finas. Tenía el cabello muy rubio y liso, y ojos\n"
                        + "de un azul intenso. Y los labios, como cerezas, parecían en verdad demasiado perfectos. Pero\n"
                        + "era mundano, del todo mortal, de una belleza y una perfección tan delicadas que inspiraban amor\n"
                        + "al mismo tiempo que compasión, amor que no podía durar.";
                fileWriter.write(content);
                fileWriter.close();
                System.out.println("Archive created.");
            }

            // 3. Read the content of the "data.txt" file and display it on the screen with
            // System.out.println() using the FileReader class.
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            System.out.println("Content of 'data.txt':");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();

            // 4. Count how many words there are in total in the "data.txt" file.
            int wordCount = countWords(dataFilePath);
            System.out.println("Words: 'datos.txt': " + wordCount);
            // 5. Copy the contents of "data.txt" to a new file called "copy.txt" in the
            // same directory my_files.
            copyFile(dataFilePath, copyFilePath);
            System.out.println("'data.txt' was copy to 'copy.txt'.");
            File copyFile = new File(copyFilePath);
            // 6. Move the file "copy.txt" to the proyect path.
            File destinationFile = new File("copy.txt");
            copyFile.renameTo(destinationFile);
            System.out.println("Archivo 'copy.txt' moved successfully");
            // 7. Get the last modification date of the "data.txt" file and display it.
            long lastModified = dataFile.lastModified();
            System.out.println("Last modified date 'data.txt': " + new java.util.Date(lastModified));

            // 8. Check if you have read and write permissions on "data.txt" & Checking if
            // the file exists, using exists() method of File class
            File file = new File(dataFilePath);
            boolean exists = file.exists();
            if (exists == true) {

                System.out.println("Executable: "
                        + file.canExecute());
                System.out.println("Readable: "
                        + file.canRead());
                System.out.println("Writable: "
                        + file.canWrite());
            }

            else {
                System.out.println("Your file hasn't read and write permissions :(");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Count Words
    private static int countWords(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int wordCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        bufferedReader.close();
        fileReader.close();
        return wordCount;
    }

    // Copy Paste optimized
    private static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFilePath);
        FileOutputStream outputStream = new FileOutputStream(destinationFilePath);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
