package assets.entities;

import java.awt.Image;

import assets.graphic.Animation;
import assets.util.Coordinates;
import assets.util.EuclidianVector;

public abstract class Entity {

	protected EuclidianVector movement;
	protected Animation animationSet;

	public Entity(Coordinates position, Animation composition) {
		this.movement = new EuclidianVector(0, 0, 0);
		this.movement.setInitialPoint(position);
		this.animationSet = composition;
	}

	
	public void setMovement(EuclidianVector movement) {
		this.movement = movement;
	}
	
	
	public EuclidianVector getMovement() {
		return movement;
	}
	
	public Coordinates getPosition() {
		return movement.getInitialPoint();
	}
	
	
	public Image getTexture() {
		return animationSet.getFrame();
	}

}

/**
 * the texture needs to change at regular intervals but does not depend on the
 * frequency at which the position / movement is updated
 */