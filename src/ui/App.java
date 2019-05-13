package ui;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import engine.Game;
import engine.Settings;

public final class App extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073528678702365030L;
	
	public App() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setResizable(false);
		setSize(Settings.APP_SIZE);

		Game game = new Game(Settings.GAME_SIZE, Settings.INVASION_STRATEGY);
		setVisible(true);
			addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					game.playerGoesLeft();
					System.out.println("left");
					break;
				case KeyEvent.VK_RIGHT:
					game.playerGoesRight();
					break;
				case KeyEvent.VK_SPACE:
					game.playerShoots();
					break;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_RIGHT:
					game.playerGoesNowhere();
				}
			}
			
		});
		
		Canvas canvas = new Canvas(game);
		add(canvas);
		canvas.beginGame();
//		setVisible(false);
//		dispose();
	}
	
}
