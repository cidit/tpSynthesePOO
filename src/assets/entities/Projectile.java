package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;

/**
 * Abstract class defining an entity produced by a mob that moves independently
 * and has an allegiance to whatever produced it.
 * 
 * @author cidit
 *
 */
public abstract class Projectile extends Entity {

	public Projectile(Coordinates position, Animation composition, Alegiance alegiance) {
		super(position, composition, alegiance);
	}

	// may be able to use ENUMs for the type of projectile and the power

}
