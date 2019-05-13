package assets.entities;

import java.util.Random;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;
import assets.util.Hitbox;
import engine.DimensionProfiles;
import engine.Settings;

public final class Invader extends Entity implements Fireable {

	private final double FIRE_PROBABILITY = Settings.FIRE_PROBABILITY_INVADER;
	Random randomizer = new Random();

	public Invader(Coordinate coordinate) {
		super(new Hitbox(coordinate, DimensionProfiles.INVADER.get()), Allegiance.HOSTILE, Settings.SPEED_INVADER);
	}

	@Override
	public Missile fire() {
		if (randomizer.nextDouble() < FIRE_PROBABILITY) {
			// center the missile properly
			int x = hitbox.getSides().getLeft() + hitbox.getDimention().getWidth() / 2
					- DimensionProfiles.MISSILE.get().getWidth() / 2;
			int y = hitbox.getSides().getBottom();

			Coordinate coordinate = new Coordinate(x, y);
			Missile missile = new Missile(coordinate, allegiance);
			missile.changeDirection(Direction.DOWN);
			return missile;
		}
		return null;
	}

}
