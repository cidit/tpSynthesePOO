package assets.entities.mobs;

import assets.entities.Alegiance;
import assets.entities.Mob;
import assets.graphic.Animation;
import assets.util.Coordinates;

/**
 * Class defining a hostile mob.
 * 
 * @author cidit
 * 
 */
public abstract class Enemy extends Mob {

	public Enemy(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH, Alegiance.HOSTILE);
		// TODO Auto-generated constructor stub
	}

}
