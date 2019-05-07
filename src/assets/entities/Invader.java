package assets.entities;

import java.util.Random;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;

public final class Invader extends Entity implements Fireable {

	Random randomizer = new Random();
	private static double FIRE_PROBABILITY = 1 / 150;

	public Invader(Coordinate position) {
		super(position, Allegiance.HOSTILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile fire() {
		if (randomizer.nextDouble() <= FIRE_PROBABILITY) {
			Missile missile = new Missile(position, allegiance);
			missile.setDirection(Direction.DOWN);
			return missile;
		}
		return null;
	}

}
