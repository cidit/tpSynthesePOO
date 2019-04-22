package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;
import assets.util.EuclidianVector;

public abstract class Entity {
	
	protected Coordinates position;
	protected EuclidianVector movement;
	protected Image[] textures;
	
	public Entity(Coordinates position, Image[] textures) {
		this.position = position;
		this.textures = textures;
	}

}
