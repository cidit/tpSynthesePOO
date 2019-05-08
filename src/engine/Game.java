package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Formation;
import assets.entities.Invader;
import assets.entities.Missile;
import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.enumerations.Status;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;
import assets.util.Dimention;

/**
 * manages every entities and the progression of the game TODO CLEAN MAGIC
 * NUMBERS
 * 
 * @author cidit
 *
 */
public final class Game {

	private Dimention surface;
	private boolean over;
	private int score;
	private Scoreboard scoreboard;

	List<Entity> entities;
	private Canon player;
	private Formation invasion;

	public Game(Dimention surface, Dimention unitOffset, Dimention invasionStrategy) {
		this.surface = surface;
		over = false;
		score = 0;
		scoreboard = new Scoreboard("scores.dat");

		final int w = surface.getWidth(), h = surface.getHeight();
		final int canonX = w - (w / 2), canonY = h - (h / 10);
		player = new Canon(new Coordinate(canonX, canonY));

		invasion = new Formation(invasionStrategy);
		invasion.setUnitSpacing(unitOffset);

		entities = new ArrayList<Entity>();
		entities.add(player);
		entities.addAll(invasion.getUnits());

	}

	// ----- updates

	public List<Entity> nextUpdate() {
		removeDestroyedEntities();
		moveEntities();
		boundaryManager();
		fireableFire();
		player.updateFireRateTimer();
		verifyPlayerStatus();
		return entities;
	}

	private void removeDestroyedEntities() {
		entities.removeIf(value -> value.getStatus() == Status.DESTROYED);
	}

	private void moveEntities() {
		for (Entity entity : entities)
			entity.move();
	}

	private void boundaryManager() {
		invasion.borderReaction(surface);
		for (Entity entity : entities)
			entity.borderReaction(surface);
	}

	private void fireableFire() {
		for (Entity entity : entities)
			if (entity instanceof Fireable) {
				Missile missile = ((Fireable) entity).fire();
				if (missile != null)
					entities.add(missile);
			}
	}

	private void verifyPlayerStatus() {
		over = player.getStatus() == Status.DESTROYED ? true : false;
	}

	// ----- player movement

	public void playerGoesRight() {
		player.setDirection(Direction.RIGHT);
	}

	public void playerGoesLeft() {
		player.setDirection(Direction.LEFT);
	}

	public void playerGoesNowhere() {
		player.setDirection(Direction.NONE);
	}

	// ----- collision

	public void collide(Entity a, Entity b) {
		boolean c1 = a instanceof Invader && b instanceof Missile && b.getAllegiance() == Allegiance.FRIENDLY;
		boolean c2 = b instanceof Invader && a instanceof Missile && a.getAllegiance() == Allegiance.FRIENDLY;
		if (c1 || c2) {
			score++;
		}
		Entity.collide(a, b);
	}
	
	// ----- scores
	
	public Scoreboard getScoreboard() {
		return scoreboard;
	}
	
	public int getScore() {
		return score;
	}

	// ----- checkers

	public boolean isOver() {
		return over;
	}
}
