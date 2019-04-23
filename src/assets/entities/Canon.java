package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;

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
		super(position, composition, MAXHEALTH);
		direction = Direction.STOPPED;

	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projectile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}
	
	private enum Direction {
		RIGHT, LEFT, FASTRIGHT, FASTLEFT, STOPPED;
	}


}
