package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreboardTest {

	@Test
	public void test() {
		Scoreboard sb = new Scoreboard("./scoreboard.txt");
		sb.addScore("e", 1);
		sb.addScore("d", 2);
		sb.addScore("c", 3);
		sb.addScore("b", 4);
		sb.addScore("a", 5);
		System.out.println(sb);
		System.out.println(sb.getHighScore());
		sb.resetScoreboard();
		sb.saveScoreboard();
		
		// I AM AMAZING
		// note: interestingly, the Scoreboard class doesnt appear to write human
		// readable information i the save file
	}

}
