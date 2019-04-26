package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;

/**
 * Class defining a missile as a type of projectile.
 * 
 * @author cidit
 *
 */
public class Missile extends Entity {
	private int damage = 10;

	public Missile(Coordinates position, Image sprite, Alegiance alegiance) {
		super(position, sprite, alegiance);
		// TODO Auto-generated constructor stub
	}
	
	public void hitTarget(Mob mob) {
		status = Status.DESTROYED;
		mob.getDamaged(damage);
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
