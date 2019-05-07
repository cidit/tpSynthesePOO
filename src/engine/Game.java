package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Fireable;
import assets.entities.Formation;
import assets.entities.Missile;
import assets.entities.Status;
import assets.util.Coordinates;
import assets.util.Dimention;

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
	private Formation invaders;
	private Dimention dimention;

	public Game(Dimention dimention) {
		over = false;
		this.width = dimention.getWidth();
		this.height = dimention.getHeight();
		this.dimention = dimention; // TODO
		
		entities = new ArrayList<Entity>();

		player = new Canon(new Coordinates(width / 2, height / 10));
		invaders = new Formation(new Dimention(4, 3));
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
			entity.borderReaction(dimention);
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
