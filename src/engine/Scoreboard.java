package engine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that instantiates a score board by reading a save file. Allows certain
 * modifications to the scoreboard. Closing function saves the new scoreboard.
 * into the file
 * 
 * may need to revise the code and use BufferedReader and BufferedWriter
 * (wrapping classes for FileWriter and FileReader)
 * 
 * @author cidit
 *
 */
public final class Scoreboard {

	private final Path path = Settings.SCOREBOARD_SAVEFILE_PATH;
	private List<Integer> scores;

	public Scoreboard() {
		scores = new ArrayList<Integer>();
		try {
			List<String> lines = Files.readAllLines(path);
			for (String string : lines) {
				scores.add(Integer.parseInt(string));
			}
		} catch (FileNotFoundException e) {
			System.out.println("SCOREBOARD SAVEFILE NOT FOUND");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param score of the player
	 * @return index of the score in the array
	 */
	public int addScore(int score) {
		for (int i = 0; i < scores.size(); i++) {
			if (score > scores.get(i)) {
				scores.add(i, score);
				return i;
			}
		}
		scores.add(score);
		return scores.size() - 1;
	}

	/**
	 * 
	 * @param playerScoreIndex
	 * @return a sublist of the scoreboard with either the player's score at the end
	 *         (if outside the top 5) or at the correct index (depending on the
	 *         rank)
	 */
	public List<Integer> getSubScoreboard(int playerScoreIndex) {
		int howManyTopScores;
		List<Integer> sub;
		if (scores.size() >= 6) {
			howManyTopScores = playerScoreIndex < 6 ? 6 : 5;
			sub = scores.subList(0, howManyTopScores);
			if (playerScoreIndex > 5)
				sub.add(scores.get(playerScoreIndex));
		} else {
			howManyTopScores = scores.size() - 1;
			sub = scores.subList(0, howManyTopScores);
			sub.add(scores.get(playerScoreIndex));
		}
		return sub;
	}

	public void resetScoreboard() {
		scores.clear();
	}

	public void saveScoreboard() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
			for (Integer score : scores) {
				writer.write(score);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
