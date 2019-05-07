package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.interfaces.Fireable;
import assets.util.Coordinate;

public final class Invader extends Entity implements Fireable {

	public Invader(Coordinate position) {
		super(position, Allegiance.HOSTILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile fire() {
		Missile missile = new Missile(position, allegiance);
		missile.setDirection(Direction.DOWN);
		return missile;
	}

}
