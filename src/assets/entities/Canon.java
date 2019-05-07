package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;
import assets.util.Counter;

public final class Canon extends Entity implements Fireable {
	
	private Counter fireInterval;

	public Canon(Coordinate position) {
		super(position, Allegiance.FRIENDLY);
		fireInterval = new Counter(10);
	}

	@Override
	public Missile fire() {
		if (fireInterval.isExpired()) {
			Missile missile = new Missile(position, allegiance);
			missile.setDirection(Direction.UP);
			fireInterval.reset();
			return missile;
		}
		return null;
	}
	
	public void updateFireRateTimer() {
		fireInterval.count();
	}

}
