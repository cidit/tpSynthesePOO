package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;

public abstract class Projectile extends Entity implements Automaton {

	public Projectile(Coordinates position, Animation composition) {
		super(position, composition);
	}
	
	//may be able to use ENUMs for the type of projectile and the power

}
