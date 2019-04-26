package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;
import assets.util.EuclidianVector;

/**
 * Abstract class defining a individual.
 * 
 * @author cidit
 *
 */
public abstract class Entity {
	protected int speed = 10;

	protected EuclidianVector movement;
	protected Image sprite;
	protected Status status;
	protected Alegiance alegiance;

	public Entity(Coordinates position, Image sprite, Alegiance alegiance) {
		this.movement = new EuclidianVector(0, 0, 0);
		this.movement.setInitialPoint(position);
		this.sprite = sprite;
		this.status = Status.OPERATIONAL;
		this.alegiance = alegiance;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}

	public EuclidianVector getMovement() {
		return movement;
	}

	public Coordinates getPosition() {
		return movement.getInitialPoint();
	}

	public Image getSprite() {
		return sprite;
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