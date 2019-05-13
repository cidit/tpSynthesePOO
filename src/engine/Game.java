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
import assets.util.Hitbox;

public final class Game {

	private static final int HALF = 2, EIGHT = 10;
	private Hitbox surface;
	private int score;

	List<Entity> entities;
	private Canon player;
	private Formation invasion;

	public Game(Dimension dimention, Dimension invasionStrategy) {
		surface = new Hitbox(new Coordinate(0, 0), dimention);
		score = 0;

		final int x, y;
		x = dimention.getWidth() / HALF - DimensionProfiles.CANON.get().getWidth() / HALF;
		y = dimention.getHeight() - (dimention.getHeight() / EIGHT);

		player = new Canon(new Coordinate(x, y));
		invasion = new Formation(invasionStrategy);
		System.out.println(player.getStatus());

		entities = new ArrayList<Entity>();
		entities.add(player);
		entities.addAll(invasion.getUnits());
	}

	public List<Entity> nextUpdate() {
		updateEntities();
		moveEntities();
		boundaryManagement();
		invasionFire();
		updateScore();
		destroyEntities();
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

	private void invasionFire() {
		List<Missile> newMissiles = new ArrayList<Missile>();
		for (Entity entity : entities)
			if (entity instanceof Invader) {
				Missile missile = ((Fireable) entity).fire();
				if (missile != null)
					newMissiles.add(missile);
			}
		entities.addAll(newMissiles);
	}

	private void updateScore() {
		for (Entity a : entities) {
			for (Entity b : entities) {
				if (Entity.checkColision(a, b)) {
					boolean c1 = a instanceof Invader && b instanceof Missile
							&& b.getAllegiance() == Allegiance.FRIENDLY;
					if (c1) {
						score++;
						System.out.println(score + "s");
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
					System.out.println("colide");
					break;
				}
			}
		}
		System.out.println("removing destroyed");
		entities.removeIf(value -> value.getStatus() == Status.DESTROYED);
	}

	private boolean isPlayerDead() {
		return player.getStatus() == Status.DESTROYED;
	}
	
	private boolean isInvasionDefeated() {
		for (Entity entity : entities) {
			if (entity instanceof Invader)
				return false;
		}
		return true;
	}

	// ----- player actions

	public void playerGoesRight() {
		player.changeDirection(Direction.RIGHT);
	}

	public void playerGoesLeft() {
		player.changeDirection(Direction.LEFT);
	}

	public void playerGoesNowhere() {
		player.changeDirection(Direction.NONE);
	}

	public void playerShoots() {
		Missile missile = player.fire();
		if (missile != null)
			entities.add(missile);
	}

	// ----- checkers

	public boolean isOver() {
		return isPlayerDead() || isInvasionDefeated();
	}

	public int getScore() {
		return score;
	}
}
