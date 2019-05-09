package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import assets.entities.Entity;
import assets.util.Coordinate;
import engine.Game;
import engine.Scoreboard;
import engine.Settings;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949282581176873115L;
	
	private Scoreboard scoreboard;
	private Timer timer;
	private Game game;
	private List<Sprite> sprites;

	public Canvas() {
		setBackground(Color.BLACK);
		setPreferredSize(Settings.APP_SIZE);
		
		scoreboard = new Scoreboard();
		timer = new Timer();		
		game = new Game(Settings.GAME_SIZE, Settings.INVASION_STRATEGY);
		sprites = new ArrayList<Sprite>();
		
	}

	public void begin() {
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				List<Entity> entities = game.nextUpdate();
				sprites.clear();
				for (Entity entity : entities) {
					BufferedImage img;
					switch (entity.getClass().getSimpleName()) {
					case "Canon":
						img = Settings.IMG_CANON;
						break;
					case "Missile":
						img = Settings.IMG_MISSILE;
					default:
						img = Settings.IMG_UFO;
					}
					sprites.add(new Sprite(entity, img));
				}
				repaint();
				if (game.isOver()) {
					triggerEndGameScreen();
					timer.cancel();
				}
				System.out.println("test");
			}
			
		}, 10, Settings.FRAMERATE_MILLIS);
	}
	
	protected void triggerEndGameScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("draw");
		drawSprites(g);
	}

	private void drawSprites(Graphics g) {
		for (Sprite sprite : sprites) {
			Coordinate coordinate = sprite.getEntity().getHitbox().getCoordinate();
			g.drawImage(sprite.getImage(), coordinate.getX(), coordinate.getY(), this);
		}
		Toolkit.getDefaultToolkit().sync();
	}

}
