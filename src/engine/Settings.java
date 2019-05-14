package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class Settings {
	
	private static int _FPS_ = 60;
	private static int _WIDTH_ = 1500;
	private static int _HEIGHT_ = 1000;
	private static int _INVASION_COLUMNS_ = 5;
	private static int _INVASION_ROWS_ = 3;
	
	public static final java.awt.Dimension APP_SIZE = new java.awt.Dimension(_WIDTH_, _HEIGHT_);
	public static final assets.util.Dimension GAME_SIZE = new assets.util.Dimension(APP_SIZE.width, APP_SIZE.height);
	public static final assets.util.Dimension INVASION_STRATEGY = new assets.util.Dimension(_INVASION_COLUMNS_, _INVASION_ROWS_);
	public static final int FRAMERATE_MILLIS = (int) 1000 / _FPS_;
	public static final Path SCOREBOARD_SAVEFILE_PATH = FileSystems.getDefault().getPath("src/engine/", "scores.dat");
	//"src/engine/scores.dat"
	
	public static final int SPEED_CANON = 3;
	public static final int SPEED_INVADER = 1;
	public static final int SPEED_MISSILE = 2;
	
	public static final int FIRE_RATE_CANON = 25;
	public static final double FIRE_PROBABILITY_INVADER = 1d / 750d;

	public static final BufferedImage IMG_CANON = loadSpriteImage("canon.png", DimensionProfiles.CANON.get());
	public static final BufferedImage IMG_MISSILE = loadSpriteImage("missile.png", DimensionProfiles.MISSILE.get());
	public static final BufferedImage IMG_UFO = loadSpriteImage("si_soucoupe.png", DimensionProfiles.INVADER.get());
	public static final BufferedImage IMG_INVADER = loadSpriteImage("monstre1_1.png", DimensionProfiles.INVADER.get());

	private static final BufferedImage loadSpriteImage(String name, assets.util.Dimension crop) {
		String pathToImages = "src/sprites/";
		BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_BYTE_GRAY);
		try {
			image = ImageIO.read(new File(pathToImages + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(crop != null) {
			BufferedImage ri = new BufferedImage(crop.getWidth(), crop.getHeight(), image.getType());
			Graphics2D g = ri.createGraphics();
			g.drawImage(image, 0, 0, crop.getWidth(), crop.getHeight(), null);
			g.dispose();
			return ri;
		}
		return image;
	}

}
