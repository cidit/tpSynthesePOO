package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;
import assets.util.EuclidianVector;

/**
 * Class defining a playable entity. Default playable entity in a regular space
 * invaders game. Only moves horizontally.
 * 
 * @author cidit
 *
 */
public class Canon extends PlayableCharacter implements Weaponized {

	public Canon(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH);
		alegiance = Alegiance.FRIENDLY;

	}

	@Override
	public Projectile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(Direction d) {
		switch (d) {
		case LEFT:
			movement.add(new EuclidianVector(-1, 0));
			break;
		case RIGHT:
			movement.add(new EuclidianVector(1, 0));
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
