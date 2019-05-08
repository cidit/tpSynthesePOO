package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.util.Dimention;
import engine.Game;
import engine.Scoreboard;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949282581176873115L;
	private static final int COLUMNS = 4;
	private static final int ROWS = 3;
	
	private final Dimension swingDimention;
	private final Dimention utilDimention;
	
	private BufferedImage canon, invader, missile;

	private Scoreboard scoreboard;
	private Game game;
	private List<Sprite> sprites;

	public Canvas(Dimension d) {
		swingDimention = d;
		utilDimention = new Dimention((int) d.getHeight(), (int) d.getWidth());
		setBackground(Color.BLACK);
		setPreferredSize(swingDimention);
		
		loadImages();
		Dimention invadersDimention = new Dimention(invader.getWidth(), invader.getHeight());
		
		scoreboard = new Scoreboard();
		// TODO add proper unit offset
		game = new Game(utilDimention, invadersDimention, new Dimention(COLUMNS, ROWS));
		
		sprites = new ArrayList<Sprite>();
	}
	
	private void loadImages() {
		String imagePath = "src/sprites/";
		try {
			canon = ImageIO.read(new File(imagePath + "canon.png"));
			invader = ImageIO.read(new File(imagePath + "monstre1_1.png"));
			missile = ImageIO.read(new File(imagePath + "missile.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		List<Entity> entities = game.nextUpdate();
		for (Entity entity : entities) {
			BufferedImage img;
			switch (entity.getClass().getSimpleName()) {
			case "Canon":
				img = canon;
				break;
			case "Invader":
				img = invader;
				break;
			case "Missile":
				img = missile;
				break;
			default:
				img = null;
			}
			Sprite sprite = new Sprite(entity, img);
			sprites.add(sprite);
		}
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSprites(g);
	}

	private void drawSprites(Graphics g) {
		for (Sprite sprite : sprites) {
			g.drawImage(sprite.getImage(), sprite.getBounds().x, sprite.getBounds().y, this);
		}
		Toolkit.getDefaultToolkit().sync();
	}

}
