package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Invader;
import assets.entities.Missile;
import assets.util.Coordinate;
import engine.Game;
import engine.Scoreboard;
import engine.Scoreboard.Score;
import engine.Settings;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949282581176873115L;

	private Timer timer;
	private Game game;
	private List<Sprite> sprites;
	private JLabel score;
	private ScoreboardPanel scoreboard;

	public Canvas(Game game) {
		setBackground(Color.BLACK);
		setPreferredSize(Settings.APP_SIZE);

		scoreboard = new ScoreboardPanel();
		add(scoreboard);

		timer = new Timer();
		sprites = new ArrayList<Sprite>();
		score = new JLabel("Your score: " + Integer.toString(game.getScore()));
		score.setForeground(Color.WHITE);
		score.setFont(new Font(score.getFont().getFontName(), Font.PLAIN, 50));
		add(score);
		this.game = game;
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
		scoreboard.setVisible(true);
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

	private class ScoreboardPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4705650242320865123L;
		private Scoreboard sb;

		public ScoreboardPanel() {
			setPreferredSize(new Dimension(Settings.APP_SIZE));
			setBackground(new Color(0, 0, 0, 100));
			setVisible(false);
			setLayout(new BorderLayout());
			sb = new Scoreboard();
			JPanel listDisplay = new JPanel();
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // TODO sketchy
			List<Score> listArray = sb.getScoreboard();
			for (Score score : listArray) {
				add(new Label(score.getName() + " : " + score.getPoints()));
			}
//			add(listDisplay, BorderLayout.EAST);
		}
	}

}
