package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;
import assets.util.Counter;
import assets.util.Hitbox;
import engine.DimensionProfiles;
import engine.Settings;

public final class Canon extends Entity implements Fireable {

	private Counter fireInterval;

	public Canon(Coordinate coordinate) {
		super(new Hitbox(coordinate, DimensionProfiles.CANON.get()), Allegiance.FRIENDLY, Settings.SPEED_CANON);
		fireInterval = new Counter(Settings.FIRE_RATE_CANON);
	}

	@Override
	public Missile fire() {
		if (fireInterval.isExpired()) {
			// center the missile properly
			int x = hitbox.getCoordinate().getX() + hitbox.getDimention().getWidth() / 2
					- DimensionProfiles.MISSILE.get().getWidth() / 2;
			int y = hitbox.getSides().getTop() - DimensionProfiles.MISSILE.get().getHeight();

			Coordinate coordinate = new Coordinate(x, y);
			Missile missile = new Missile(coordinate, allegiance);
			missile.changeDirection(Direction.UP);
			fireInterval.reset();
			return missile;
		}
		return null;
	}

	@Override
	public void update() {
		fireInterval.count();
	}

}
