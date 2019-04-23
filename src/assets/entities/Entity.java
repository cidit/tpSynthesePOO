package assets.entities;

import java.awt.Image;

import assets.graphic.Animation;
import assets.util.Coordinates;
import assets.util.EuclidianVector;

/**
 * Abstract class defining a individual.
 * 
 * @author cidit
 *
 */
public abstract class Entity {

	protected EuclidianVector movement;
	protected Animation animationSet;
	protected Status status;

	public Entity(Coordinates position, Animation composition) {
		this.movement = new EuclidianVector(0, 0, 0);
		this.movement.setInitialPoint(position);
		this.animationSet = composition;
		this.status = Status.OPERATIONAL;
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

	public void setAnimation(Animation animationSet) {
		this.animationSet = animationSet;
	}

	public Status getStatus() {
		return status;
	}
	
	public abstract void update();

}

/**
 * the texture needs to change at regular intervals but does not depend on the
 * frequency at which the position / movement is updated
 */