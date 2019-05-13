package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Invader;
import assets.entities.Missile;
import assets.util.Coordinate;
import engine.Game;
import engine.Settings;

public class GameScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949282581176873115L;

	private Timer timer;
	private Game game;
	private List<Sprite> sprites;
	private JLabel score;

	private ActionListener actionListener;

	public GameScreen(Game game) {
		this.game = game;
		setBackground(Color.BLACK);
		setSize(Settings.APP_SIZE);

		timer = new Timer();
		sprites = new ArrayList<Sprite>();
		score = new JLabel("Your score: " + Integer.toString(game.getScore()));
		score.setForeground(Color.WHITE);
		score.setFont(new Font(score.getFont().getFontName(), Font.PLAIN, 50));
		add(score);
		
	}

	public void beginGame() {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				List<Entity> entities = game.nextUpdate();
				System.out.println(entities.size());
				sprites.clear();
				for (Entity entity : entities) {
					BufferedImage img;
					if (entity instanceof Canon)
						img = Settings.IMG_CANON;
					else if (entity instanceof Invader)
						img = Settings.IMG_INVADER;
					else if (entity instanceof Missile)
						img = Settings.IMG_MISSILE;
					else
						img = Settings.IMG_UFO;
					sprites.add(new Sprite(entity, img));
				}
				score.setText("Your score: " + Integer.toString(game.getScore()));
				repaint();
				if (!game.isOver())
					return;
				System.out.println("game stops");
				triggerEndGameScreen();
				timer.cancel();
				System.out.println("run ends");
			}

		}, 10, Settings.FRAMERATE_MILLIS);
	}

	private void triggerEndGameScreen() {
		actionListener.actionPerformed(new ActionEvent(this, 0, "score screen"));
	}
	
    // ActionEvent source
    public void addActionListener(ActionListener listener) {
        if (actionListener != null) {
        	System.out.println("GameScreen can only have *1* ActionListener");
        	return;
        } else 
        	actionListener = listener;
    }
    public void removeActionListener(ActionListener listener) {
        actionListener = null;
    }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("draw");
		drawSprites(g);
	}

	private void drawSprites(Graphics g) {
		Sprite[] sprites = new Sprite[this.sprites.size()];
		this.sprites.toArray(sprites);
		for (Sprite sprite : sprites) {
			Coordinate coordinate = sprite.getEntity().getHitbox().getCoordinate();
			g.drawImage(sprite.getImage(), coordinate.getX(), coordinate.getY(), this);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public final class Sprite {

		private BufferedImage img;
		private Entity e;
		
		public Sprite(Entity e, BufferedImage img) {
			// TODO Auto-generated constructor stub
			this.img = img;
			this.e = e;
		}
		
		public BufferedImage getImage() {
			return img;
		}
		
		public Entity getEntity() {
			return e;
		}
	}


}
