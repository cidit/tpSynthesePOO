package engine;

import java.util.ArrayList;
import java.util.List;

import assets.entities.Entity;

public final class Game {
	
	private int width, height;
	List<Entity> entities;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		entities = new ArrayList<Entity>();
		
	}

	public void nextUpdate() {
		
		
		
	}
	
	private void movementManager() {
		for (Entity entity : entities) {
			entity.move();
		}
	}
	
	private void boundaryManager() {
		for (Entity entity : entities) {
			entity.fixPosition(width, height);
		}
	}
	
}
