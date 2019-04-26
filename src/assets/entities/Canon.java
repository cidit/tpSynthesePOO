package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;
import assets.util.EuclidianVector;

/**
 * Class defining a playable entity. Default playable entity in a regular space
 * invaders game. Only moves horizontally.
 * 
 * @author cidit
 *
 */
public class Canon extends Mob implements Weaponized {

	public Canon(Coordinates position, Image sprite, int MAXHEALTH) {
		super(position, sprite, MAXHEALTH, Alegiance.FRIENDLY);

	}

	@Override
	public Projectile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	public void move(Direction d) {
		switch (d) {
		case LEFT:
			movement.add(new EuclidianVector(-3*speed, 0));
			break;
		case RIGHT:
			movement.add(new EuclidianVector(3*speed, 0));
			break;
		case NONE:
			movement.setTerminalPoint(movement.getInitialPoint());
			break;
		default:
		}
	}

	@Override
	protected void getOperationnal() {
		// TODO
		movement.setInitialPoint(movement.getTerminalPoint());
	}

	@Override
	protected void getHit() {
		// TODO 
		status = Status.INVINCIBLE;

	}

	@Override
	protected void getDestroyed() {
		// TODO Auto-generated method stub

	}

}
