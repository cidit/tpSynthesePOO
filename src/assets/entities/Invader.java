package assets.entities;

import assets.util.Coordinates;

public final class Invader extends Entity implements Fireable {
	
	protected static Direction direction;

	public Invader(Coordinates position) {
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
