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
public class Cannon extends Mob implements Playable, Weaponized {

	public Cannon(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH);

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

}
