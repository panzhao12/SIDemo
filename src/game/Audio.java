package game;

import java.io.File;

import javax.sound.sampled.*;

public class Audio {
	private static Clip clip;
	public Audio(String sound) {
		// create an audio input stream from the given source
		try {
			File file = new File(sound);
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			// acquire the audio format and create the Dataline.Info object
			// obtain the clip
			clip = AudioSystem.getClip();
			// open the audio input stream and start playing
			clip.open(audio);
		} catch (Exception e) {
		}
	}

	// a method to stop the song
	public static void stop() {
		clip.stop();
	}

	// a static method to start playing the song
	public static void playSound(String sound) {
		Audio audio = new Audio(sound);
		audio.play();
	}

	// method to start and stop the song
	public void play() {
		clip.start();
	}

}