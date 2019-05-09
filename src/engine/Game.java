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
import assets.util.Dimension;
import assets.util.DimentionProfiles;
import assets.util.Hitbox;

public final class Game {

	private static final int HALF = 2, EIGHT = 10;
	private Hitbox surface;
	private boolean over;
	private int score;

	List<Entity> entities;
	private Canon player;
	private Formation invasion;

	public Game(Dimension dimention, Dimension invasionStrategy) {
		surface = new Hitbox(new Coordinate(0, 0), dimention);
		over = false;
		score = 0;

		final int x, y;
		x = dimention.getWidth() / HALF - DimentionProfiles.getCanon().getWidth() / HALF;
		y = dimention.getHeight() - (dimention.getHeight() / EIGHT);

		player = new Canon(new Coordinate(x, y));
		invasion = new Formation(invasionStrategy);

		entities = new ArrayList<Entity>();
		entities.add(player);
		entities.addAll(invasion.getUnits());
	}

	public List<Entity> nextUpdate() {
		updateEntities();
		moveEntities();
		boundaryManagement();
//		fireablesFire();
		updateScore();
//		destroyEntities(); 
		removeDestroyedEntities(); 
		verifyPlayerStatus();
		return entities;
	}

	// ----- actions

	private void updateEntities() {
		for (Entity entity : entities) {
			entity.update();
		}
	}

	private void moveEntities() {
		for (Entity entity : entities)
			entity.move();
	}

	private void boundaryManagement() {
		invasion.reactToBorder(surface);
		for (Entity entity : entities)
			entity.reactToBorder(surface);
	}

	private void fireablesFire() {
		for (Entity entity : entities)
			if (entity instanceof Fireable) {
				Missile missile = ((Fireable) entity).fire();
				if (missile != null)
					entities.add(missile);
			}
	}

	private void updateScore() {
		boolean c1, c2;
		for (Entity a : entities) {
			for (Entity b : entities) {
				if (Entity.checkColision(a, b)) {
					c1 = a instanceof Invader && b instanceof Missile && b.getAllegiance() == Allegiance.FRIENDLY;
					c2 = b instanceof Invader && a instanceof Missile && a.getAllegiance() == Allegiance.FRIENDLY;
					if (c1 || c2) {
						score++;
					}
				}
			}
		}
	}

	private void destroyEntities() {
		for (Entity a : entities) {
			for (Entity b : entities) {
				if (Entity.checkColision(a, b) && a.getAllegiance() != b.getAllegiance()) {
					a.getDestroyed();
					b.getDestroyed();
				}
			}
		}
	}

	private void removeDestroyedEntities() {
		entities.removeIf(value -> value.getStatus() == Status.DESTROYED);
	}

	private void verifyPlayerStatus() {
		over = player.getStatus() == Status.DESTROYED;
	}

	// ----- player movement

	public void playerGoesRight() {
		player.changeDirection(Direction.RIGHT);
	}

	public void playerGoesLeft() {
		player.changeDirection(Direction.LEFT);
	}

	public void playerGoesNowhere() {
		player.changeDirection(Direction.NONE);
	}

	// ----- checkers

	public boolean isOver() {
		return over;
	}

	public int getScore() {
		return score;
	}
}
