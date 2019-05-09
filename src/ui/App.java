package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public final class App extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073528678702365030L;
	
	//this Dimention is from swing
	private static Dimension APP_SIZE = new Dimension((int) 1536, (int) 1000);

	public App() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Canvas game = new Canvas(APP_SIZE);
		add(game);
		setBackground(Color.BLACK);
		setResizable(false);
		pack();
		setVisible(true);
		game.run();
		setVisible(false);
		dispose();
	}
	
}
