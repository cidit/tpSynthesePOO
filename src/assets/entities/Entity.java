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

	protected static int speed = 10;
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

	public static void setSpeed(int speed) {
		Entity.speed = speed;
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
		case OPERATIONAL:
			getOperationnal();
			break;
		}

	}

	protected abstract void getOperationnal();

	protected abstract void getHit();

	protected abstract void getDestroyed();

	/**
	 * Enumeration of possible allegiances an entity can have towards the player
	 * 
	 * @author cidit
	 *
	 */
	public static enum Alegiance {

		FRIENDLY, HOSTILE, NEUTRAL, NONE;

	}

	/**
	 * Enumeration of possible statuses that an entity can have.
	 * 
	 * @author cidit
	 *
	 */
	public static enum Status {

		OPERATIONAL, HIT, DESTROYED;

	}
}

/**
 * the texture needs to change at regular intervals but does not depend on the
 * frequency at which the position / movement is updated
 */