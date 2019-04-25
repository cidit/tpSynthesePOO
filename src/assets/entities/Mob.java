package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;

/**
 * Abstract class defining an entity with a concept of health.
 * 
 * @author cidit
 *
 */
public abstract class Mob extends Entity {

	private final int MAXHEALTH;
	private int damage;

	public Mob(Coordinates position, Animation composition, int MAXHEALTH, Alegiance alegiance) {
		super(position, composition, alegiance);
		this.MAXHEALTH = MAXHEALTH;
		this.damage = 0;
	}

	public void getDamaged(int damage) {
		this.damage += damage;
	}

	public int getHealth() {
		return MAXHEALTH - damage;
	}

	public int getMaxHealth() {
		return MAXHEALTH;
	}

}
