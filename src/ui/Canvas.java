package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	
	private ImageIcon canon, invader, missile;

	private Scoreboard scoreboard;
	private Game game;
	private List<Entity> entities;
	private List<Sprite> sprites;

	public Canvas(Dimension d) {
		swingDimention = d;
		utilDimention = new Dimention((int) d.getHeight(), (int) d.getWidth());
		setBackground(Color.BLACK);
		setPreferredSize(swingDimention);
		
		loadImages();
		Dimention invadersDimention = new Dimention(invader.getIconWidth(), invader.getIconHeight());
		
		scoreboard = new Scoreboard();
		// TODO add proper unit offset
		game = new Game(utilDimention, invadersDimention, new Dimention(COLUMNS, ROWS));
		
		entities = new ArrayList<Entity>();
		sprites = new ArrayList<Sprite>();
	}
	
	private void loadImages() {
		String imagePath = "src/sprites/";
		canon = new ImageIcon(imagePath + "canon.png");
		invader = new ImageIcon(imagePath + "mostre1_1.png");
		missile = new ImageIcon(imagePath + "missile.png");
	}

	public void run() {
		
	}

}
