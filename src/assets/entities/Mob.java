package assets.entities;

import java.awt.Image;

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

	public Mob(Coordinates position, Image sprite, int MAXHEALTH, Alegiance alegiance) {
		super(position, sprite, alegiance);
		this.MAXHEALTH = MAXHEALTH;
		this.damage = 0;
	}

	public final void getDamaged(int damage) {
		this.damage += damage;
		status = Status.HIT;
	}

	public final int getHealth() {
		return MAXHEALTH - damage;
	}

	public final int getMaxHealth() {
		return MAXHEALTH;
	}

}
