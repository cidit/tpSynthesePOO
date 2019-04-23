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
	public Projectile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move() {
		switch (direction) {
		case LEFT:
			break;
		case RIGHT:
			break;
		case FASTLEFT:
			break;
		case FASTRIGHT:
			break;
		case STOPPED:
			break;
			
		}

	}
	
	private enum Direction {
		RIGHT, LEFT, FASTRIGHT, FASTLEFT, STOPPED;
	}

	@Override
	protected void getOperationnal() {
		switch (direction) {
		case LEFT:
			direction = Direction.FASTLEFT;
			break;
		case RIGHT:
			direction = Direction.FASTRIGHT;
			break;
		}
		// TODO continue this
		move();
	}


	@Override
	protected void getHit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void getDestroyed() {
		// TODO Auto-generated method stub
		
	}


}
