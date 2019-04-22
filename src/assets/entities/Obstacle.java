package assets.entities;

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
public abstract class Obstacle extends Entity implements Automaton {

	public Obstacle(Coordinates position, Animation composition) {
		super(position, composition);
		// TODO Auto-generated constructor stub
	}

}
