package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import engine.Game;
import engine.Scoreboard;
import engine.Settings;

public class ScoreScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210129213463539406L;

	private Game game;
	private DefaultListModel<String> listModel;
	private JPanel panel;

	public ScoreScreen(Game game) {
		setBackground(new Color(0, 0, 0, 100));
		setSize(Settings.APP_SIZE);
		setLayout(null);

		this.game = game;

		JLabel label = new JLabel("SCOREBOARD");
		listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		panel = new JPanel(new BorderLayout());
		panel.setBounds(Settings.APP_SIZE.width / 3, Settings.APP_SIZE.height / 4, Settings.APP_SIZE.width / 3, Settings.APP_SIZE.height / 2);
		
		panel.add(label, BorderLayout.NORTH);
		panel.add(list, BorderLayout.CENTER);
		this.add(panel);
	}

	public void makeScoreboard() {
		Scoreboard sb = new Scoreboard();
		int playerScoreIndex = sb.addScore(game.getScore());
		List<Integer> scores = sb.getSubScoreboard(playerScoreIndex);
		List<String> list = new ArrayList<String>(scores.size());
		for (int rank = 1; rank <= scores.size(); rank++) {
			list.add(String.valueOf(rank));
		}
		if (playerScoreIndex >= scores.size()) {
			list.remove(list.size() - 1);
			list.add(String.valueOf(playerScoreIndex + 1));
			playerScoreIndex = list.size() -1;
		}
		for (int i = 0; i < scores.size(); i++) {
			list.set(i, list.get(i).concat(" : " + scores.get(i)));
		}
		list.set(playerScoreIndex, list.get(playerScoreIndex).concat(" <-YOUR SCORE"));
		for (String s : list) {
			listModel.addElement(s);
		}
		sb.saveScoreboard();
	}
}
