/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bill Ganley
 */
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class AudioPlayer {
   
   // Constructor
   public AudioPlayer() 
   {
   
   }
   
   void play(String fileName)
   {
        try {
            // Open an audio input stream.
            //URL url = this.getClass().getClassLoader().getResource(fileName);
            URL url = this.getClass().getResource("/sounds/" + fileName);            

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("AudioPlayer caugher exception");
        }       
   }
}
