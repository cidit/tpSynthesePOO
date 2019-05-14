package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Scoreboard;
import engine.Settings;

public class ScoreScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210129213463539406L;

	private Game game;
	private Scoreboard scoreboard;
	private DefaultListModel<String> listModel;
	private JPanel panel;

	public ScoreScreen(Game game) {
		setBackground(new Color(0, 0, 0, 100));
		setSize(Settings.APP_SIZE);
		setLayout(null);

		this.game = game;
		this.scoreboard = new Scoreboard();

		listModel = new DefaultListModel<String>();
		JList<String> List = new JList<String>(listModel);
		
		panel = new JPanel();
		
	}

}
