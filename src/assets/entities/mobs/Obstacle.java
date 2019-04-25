package assets.entities.mobs;

import assets.entities.Alegiance;
import assets.entities.Mob;
import assets.graphic.Animation;
import assets.util.Coordinates;

/**
 * Abstract class defining an entity that moves independently and has no
 * allegiance.
 * 
 * # OPTIONNAL TO THE SPA
 * 
 * @author cidit
 *
 */
public abstract class Obstacle extends Mob {

	public Obstacle(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH, Alegiance.NONE);
		// TODO Auto-generated constructor stub
	}

}
