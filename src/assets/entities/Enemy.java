package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;

/**
 * Class defining a hostile mob.
 * 
 * @author cidit
 * 
 */
public class Enemy extends Mob {

	public Enemy(Coordinates position, Image sprite, int MAXHEALTH) {
		super(position, sprite, MAXHEALTH, Alegiance.HOSTILE);
		// TODO Auto-generated constructor stub
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
