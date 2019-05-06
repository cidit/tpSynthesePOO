package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Fireable;
import assets.entities.Missile;
import assets.entities.Status;
import assets.util.Coordinates;

/**
 * manages every entities and the progression of the game
 * 
 * @author cidit
 *
 */
public final class Game {

	private boolean over;
	private int width, height;

	List<Entity> entities;
	private Canon player;

	public Game(int width, int height) {
		over = false;
		this.width = width;
		this.height = height;
		entities = new ArrayList<Entity>();

		player = new Canon(new Coordinates(width / 2, height / 10));
		entities.add(player);
	}

	public List<Entity> nextUpdate() {
		// TODO
		return entities;
	}

	private void moveEntities() {
		for (Entity entity : entities)
			entity.move();
	}

	private void boundaryManager() {
		for (Entity entity : entities)
			entity.borderReaction(width, height);
	}
	
	private void addNewMissiles() {
		for (Entity entity : entities)
			if(entity instanceof Fireable) {
				Missile missile = ((Fireable) entity).fire();
				if (missile != null)
					entities.add(missile);
			}
	}

	private void removeDestroyedEntities() {
		entities.removeIf(value -> value.getStatus() == Status.DESTROYED);
	}

}
