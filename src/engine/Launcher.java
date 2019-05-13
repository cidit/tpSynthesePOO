package engine;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ui.ScreenManager;

public class Launcher {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				Game game = new Game(Settings.GAME_SIZE, Settings.INVASION_STRATEGY);
				JFrame f = new JFrame("Space Invader");
				f.setBackground(Color.BLACK);
				f.setSize(Settings.APP_SIZE);
				f.setResizable(false);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.add(new ScreenManager(game));

				f.addKeyListener(new KeyAdapter() {

					@Override
					public void keyPressed(KeyEvent e) {
						super.keyPressed(e);
						switch (e.getKeyCode()) {
						case KeyEvent.VK_LEFT:
							game.playerGoesLeft();
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

			}

		});
	}

}
