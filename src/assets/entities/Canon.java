package assets.entities;

import assets.util.Coordinates;

public final class Canon extends Entity implements Fireable {

	public Canon(Coordinates position) {
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
