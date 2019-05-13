package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import engine.Game;
import engine.Scoreboard;
import engine.Settings;

public class ScoreScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210129213463539406L;
	
	private Game game;
	private Scoreboard scoreboard;
	
	public ScoreScreen(Game game) {
		setBackground(new Color(0, 0, 0, 100));
		setSize(Settings.APP_SIZE);
		setLayout(new BorderLayout());
		
		this.game = game;
		this.scoreboard = new Scoreboard();
		
	}

}
