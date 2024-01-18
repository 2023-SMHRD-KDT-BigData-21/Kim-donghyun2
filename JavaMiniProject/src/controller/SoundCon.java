package controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundCon {
	private Clip clip;

	public void playSound(String pathName, boolean isLoop) {
		try {
			clip = AudioSystem.getClip();
			File audiofile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audiofile);
			clip.open(audioStream);
			clip.start();
			if (isLoop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	

}
