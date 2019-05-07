package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Canon;
import assets.entities.Entity;
import assets.entities.Formation;
import assets.entities.Missile;
import assets.entities.enumerations.Status;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;
import assets.util.Dimention;

/**
 * manages every entities and the progression of the game
 * TODO CLEAN MAGIC NUMBERS
 * 
 * @author cidit
 *
 */
public final class Game {

	private boolean over;
	private Dimention surface;

	List<Entity> entities;
	private Canon player;
	private Formation invaders;
	private Dimention entityDimention = new Dimention(8, 8);

	public Game(Dimention surface) {
		this.surface = surface;
		over = false;
		
		entities = new ArrayList<Entity>();

		player = new Canon(new Coordinate(surface.getWidth() / 2, surface.getHeight() / 10));
		invaders = new Formation(new Dimention(4, 3));
		invaders.setUnitSpacing(entityDimention);
		
		entities.add(player);
		entities.addAll(invaders.getUnits());
		
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
		invaders.borderReaction(surface);
		for (Entity entity : entities)
			entity.borderReaction(surface);
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
