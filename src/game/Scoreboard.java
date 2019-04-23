package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that instantiates a score board by reading a save file. Allows certain
 * modifications to the scoreboard. Closing function saves the new scoreboard
 * into the file
 * 
 * @author cidit
 *
 */
public class Scoreboard {

	private List<Score> scores;
	private final String filePath;

	public Scoreboard(String filePath) {
		scores = new ArrayList<Score>();
		this.filePath = filePath;

		// TODO fill the arraylist with a loop going through the save file
	}

	public void addScore(String name, int points) {
		Score newScore = new Score(name, points);
		boolean added = false;
		for (Score score : scores) {
			if (score.getName() == newScore.getName())
				if (score.getPoints() < newScore.getPoints()) {
					score.setPoints(newScore.getPoints());
					added = true;
				}
		}
		if (!added) {
			scores.add(newScore);
			scores.sort(null);
		}
	}

	public Score getHighScore() {
		return scores.get(0);
	}

	public void resetScoreboard() {
		scores.clear();
	}

	public void saveScoreboard() {
		// TODO scoreboard-saving magic
	}

	/**
	 * class defining a score
	 * 
	 * @author cidit
	 *
	 */
	private static class Score implements Comparable<Score> {

		private String name;
		private int points;

		public Score(String name, int points) {
			this.name = name;
			this.points = points;
		}

		public String getName() {
			return name;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}

		public String toString() {
			return name + " " + points;
		}

		@Override
		public int compareTo(Score o) {
			return this.points - o.points;
		}
	}
}
