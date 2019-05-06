package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Canon;
import assets.entities.Entity;
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
		entities = new ArrayList<Entity>(); // may use CopyOnWriteArrayList later

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
			entity.fixPosition(width, height);
	}

	private void removeDestroyedEntities() {
		entities.removeIf(value -> value.getStatus() == Status.DESTROYED);
	}

}
