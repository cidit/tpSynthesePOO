package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;

/**
 * Class defining a hostile mob.
 * 
 * @author cidit
 * 
 */
public class Invader extends Mob {

	public Invader(Coordinates position, Image sprite, int MAXHEALTH) {
		super(position, sprite, MAXHEALTH, Alegiance.HOSTILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void getOperationnal() {
		// TODO Auto-generated method stub

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
