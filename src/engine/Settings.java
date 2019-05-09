package engine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import assets.util.DimentionProfiles;

public class Settings {

	{
		assets.util.Dimension canon = new assets.util.Dimension(150, 150);
		assets.util.Dimension invader = new assets.util.Dimension(100, 100);
		assets.util.Dimension missile = new assets.util.Dimension(16, 80);
		assets.util.DimentionProfiles.setProfiles(canon, invader, missile);
	}
	
	public static final java.awt.Dimension APP_SIZE = new java.awt.Dimension(1536, 1000);
	public static final assets.util.Dimension GAME_SIZE = new assets.util.Dimension(APP_SIZE.width, APP_SIZE.height);
	public static final assets.util.Dimension INVASION_STRATEGY = new assets.util.Dimension(5, 3);
	public static final int FRAMERATE_MILLIS = (int) 1000 / 60;
	
	public static final BufferedImage IMG_CANON = loadSpriteImage("canon.png", DimentionProfiles.getCanon());
	public static final BufferedImage IMG_MISSILE = loadSpriteImage("missile.png", DimentionProfiles.getMissile());
	public static final BufferedImage IMG_UFO = loadSpriteImage("si_soucoupe.png", DimentionProfiles.getInvader());
	public static final List<BufferedImage[]> IMG_INVADERS = loadInvaderSpriteImages("monstre", 3);

	private static final BufferedImage loadSpriteImage(String name, assets.util.Dimension crop) {
		String pathToImages = "src/sprites/";
		BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_BYTE_GRAY);
		try {
			image = ImageIO.read(new File(pathToImages + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(crop != null)
			image.getScaledInstance(crop.getWidth(), crop.getHeight(), Image.SCALE_SMOOTH);
		return image;
	}

	private static final ArrayList<BufferedImage[]> loadInvaderSpriteImages(String name, int differentTypes){
		ArrayList<BufferedImage[]> invaderSpriteImages = new ArrayList<BufferedImage[]>(differentTypes);
		int STATES = 2;
		for (int i = 0; i < invaderSpriteImages.size(); i++) {
			BufferedImage[] bufferedImages = invaderSpriteImages.get(i);
			bufferedImages = new BufferedImage[STATES];
			for (int j = 0; j < bufferedImages.length; j++)
				bufferedImages[j] = loadSpriteImage(name + i + "_" + j + ".png" , DimentionProfiles.getInvader());
		}
		return invaderSpriteImages;
	}
}