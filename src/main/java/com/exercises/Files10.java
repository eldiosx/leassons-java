package com.exercises;

/*Play .mp3 file */

import javax.sound.sampled.*;
import java.io.*;

public class Files10 {

    public static void main(String[] args) {

        // Unix type clear console :3
        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            File mp3File = new File("src/main/resources/song.mp3");

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(mp3File);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            System.out.println("Playing...");
            clip.start();

            // Wait the song end
            while (!clip.isRunning()) {
                Thread.sleep(0);
            }
            while (clip.isRunning()) {
                Thread.sleep(10);
            }

            System.out.println("End.");

            clip.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
