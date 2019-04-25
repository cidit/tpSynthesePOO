package assets.entities.mobs;

import assets.entities.Alegiance;
import assets.entities.Direction;
import assets.entities.Mob;
import assets.entities.Weaponized;
import assets.graphic.Animation;
import assets.util.Coordinates;

/**
 * Interface representing something that the player can control via specific
 * actions.
 * 
 * @author cidit
 *
 */
public abstract class PlayableCharacter extends Mob implements Weaponized {

	public PlayableCharacter(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition, MAXHEALTH, Alegiance.FRIENDLY);
		// TODO Auto-generated constructor stub
	}

	public abstract void move(Direction direction);
	
}
