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
	protected Alegiance alegiance;

	public Entity(Coordinates position, Animation composition, Alegiance alegiance) {
		this.movement = new EuclidianVector(0, 0, 0);
		this.movement.setInitialPoint(position);
		this.animationSet = composition;
		this.status = Status.OPERATIONAL;
		this.alegiance = alegiance;
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
	
	public Alegiance getAlegiance() {
		return alegiance;
	}
	
	public void update() {
		switch (status) {
		case DESTROYED:
			getDestroyed();
			break;
		case HIT:
			getHit();
			break;
		case INVINCIBLE:
		case OPERATIONAL:
			getOperationnal();
			break;
		}
		
	}

	protected abstract void getOperationnal();

	protected abstract void getHit();

	protected abstract void getDestroyed();

}

/**
 * the texture needs to change at regular intervals but does not depend on the
 * frequency at which the position / movement is updated
 */