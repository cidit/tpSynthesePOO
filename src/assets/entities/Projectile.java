package assets.entities;

import java.awt.Image;

import assets.util.Coordinates;

/**
 * Abstract class defining an entity produced by a mob that moves independently
 * and has an allegiance to whatever produced it.
 * 
 * @author cidit
 *
 */
public abstract class Projectile extends Entity {

	public Projectile(Coordinates position, Image sprite, Alegiance alegiance) {
		super(position, sprite, alegiance);
	}

	// may be able to use ENUMs for the type of projectile and the power

}
