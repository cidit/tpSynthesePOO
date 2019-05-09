package ui;

import java.awt.Color;

import javax.swing.JFrame;

public final class App extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073528678702365030L;
	
	public App() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Canvas game = new Canvas();
		add(game);
		setBackground(Color.BLACK);
		setResizable(false);
		pack();
		setVisible(true);
//		game.run();
//		setVisible(false);
//		dispose();
	}
	
}
