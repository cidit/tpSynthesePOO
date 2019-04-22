package assets.entities;

import assets.graphic.Animation;
import assets.util.Coordinates;

public class Mob extends Entity{
	
	private final int MAXHEALTH;
	private int damage;

	public Mob(Coordinates position, Animation composition, int MAXHEALTH) {
		super(position, composition);
		this.MAXHEALTH = MAXHEALTH;
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
