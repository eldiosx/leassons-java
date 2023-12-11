package com.leassons;

/* Files & Directories */

import java.io.File;
import java.io.IOException;

public class Leasson2 {

    public static void createFile() throws IOException {
        File file = new File("src/main/resources/test.txt");
        file.createNewFile();
    }

    public static void deleteFile() {
        File file = new File("src/main/resources/test.txt");
        file.delete();
    }

    public static void createDir() {
        File dir = new File("src/main/resources/newDirectory");
        dir.mkdirs();
    }

    public static void getName() {
        File file = new File("src/main/resources/document.pdf");
        String name = file.getName();
        System.out.println(name);
    }

    public static void getPath() {
        File file = new File("src/main/resources/documents/reports/report1.odt");
        String path = file.getPath();
        System.out.println(path);
    }

    public static void getParent() {
        File file = new File("src/main/resources/documents/reports/report1.odt");
        String parent = file.getParent();
        System.out.println(parent);
    }

    public static void rename() {
        File old = new File("src/main/resources/document.txt");
        File nuevo = new File("src/main/resources/documents/rename.txt");
        old.renameTo(nuevo);
    }

    public static void exists() {
        File file = new File("src/main/resources/data.ods");
        if (file.exists()) {
            System.out.println("Exist");
        } else {
            System.out.println("No exist");
        }
    }

    public static void main(String[] args) throws IOException {
        // createNewFile();
        // deleteFile();
        // createDir();
        // getName();
        // getPath();
        // getParent();
        // renameTo();
        // exists();
    }

}
