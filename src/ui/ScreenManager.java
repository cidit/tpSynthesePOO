package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import engine.Game;

public final class ScreenManager extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073528678702365030L;
	private static final String GAME_SCREEN = "game screen";
	private static final String SCORE_SCREEN = "score screen";
	
	GameScreen gameScreen;
	ScoreScreen scoreScreen;
	
	public ScreenManager(Game game) {
		super();
		setLayout(new CardLayout());
		
		gameScreen = new GameScreen(game);
		scoreScreen = new ScoreScreen(game);
		
		add(GAME_SCREEN, gameScreen);
		add(SCORE_SCREEN, scoreScreen);
		
		gameScreen.addActionListener(this);
		
		gameScreen.beginGame();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		scoreScreen.makeScoreboard();
		CardLayout cl = (CardLayout) getLayout();
		cl.show(this, SCORE_SCREEN);
	}
	
}
