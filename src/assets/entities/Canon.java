package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;
import assets.util.EuclidianVector;

/**
 * Class defining a playable entity. Default playable entity in a regular space
 * invaders game.
 * 
 * @author cidit
 *
 */
public class Canon extends Mob implements Playable, Weaponized {

	private Direction direction;

	public Canon(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH, Alegiance.FRIENDLY);
		direction = Direction.NONE;
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
			movement = new EuclidianVector(-1, 0);
			direction = Direction.LEFT;
			break;
		case RIGHT:
			movement = new EuclidianVector(1, 0);
			direction = Direction.RIGHT;
			break;
		case NONE:
			movement = new EuclidianVector(0, 0);
			direction = Direction.NONE;
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
		// trigger game over OR lose a life

	}

}
