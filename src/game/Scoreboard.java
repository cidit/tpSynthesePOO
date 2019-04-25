package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	private final String savePath;

	public Scoreboard(String savePath) {
		scores = new ArrayList<Score>();
		this.savePath = savePath;

		try (FileReader reader = new FileReader(savePath)) {
			fillScoresArray(reader);
		} catch (FileNotFoundException e) {
			System.out.println("SCOREBOARD SAVEFILE NOT FOUND");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void fillScoresArray(FileReader reader) {
		String builder = "";
		try {
			int ch = reader.read();
			while (ch != -1) {
				builder += (char) ch;
				ch = reader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		int start = 0, end = builder.indexOf(';');
		while (end != -1) {
			int delimiter = builder.indexOf(':', start);
			String name = builder.substring(start, delimiter);
			int points = Integer.parseInt(builder.substring(delimiter + 1, end));
			start = end + 1;
			end = builder.indexOf(';', start);
			scores.add(new Score(name, points));
		}

	}

	public void addScore(String name, int points) {
		boolean added = false;
		for (Score score : scores) {
			if (score.getName() == name)
				if (score.getPoints() < points) {
					score.setPoints(points);
					added = true;
				}
		}
		if (!added) {
			scores.add(new Score(name, points));
		}
		scores.sort(null);
	}

	public Score getHighScore() {
		return scores.get(0);
	}
	
	public List<Score> getScoreboard() {
		return scores;
	}

	public void resetScoreboard() {
		scores.clear();
	}

	public void saveScoreboard() {
		try (FileWriter writer = new FileWriter(savePath)) {
			writer.write(toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Score score : scores) {
			s += score.toString();
		}
		return s;
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
			return name + ":" + points + ";";
		}

		// might end up faulty, verify when testing that highscore is at beginning
		@Override
		public int compareTo(Score o) {
			return o.points - this.points;
		}
	}
}
