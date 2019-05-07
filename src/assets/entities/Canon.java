package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;

public final class Canon extends Entity implements Fireable {

	public Canon(Coordinate position) {
		super(position, Allegiance.FRIENDLY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile fire() {
		Missile missile = new Missile(position, allegiance);
		missile.setDirection(Direction.UP);
		return missile;
	}

}
