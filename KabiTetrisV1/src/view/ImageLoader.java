package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ImageLoader {
	
	private final static Logger LOG = Logger.getGlobal();
	
	public static BufferedImage loadImage(String path){
		LOG.info("*** Start ***");
		try {
			LOG.info(path);
			
			return ImageIO.read(new File(path));
			
//			File file = new File(path);
//			return ImageIO.read(file);
//			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		LOG.info("*** Finish ***");
		return null;
	}
	public static Clip LoadSound(String direction){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(direction)));
//			clip.open(AudioSystem.getAudioInputStream(ImageLoader.class.getResource(direction)));
//			return ImageIO.read(new File(path));
			
			return clip;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
