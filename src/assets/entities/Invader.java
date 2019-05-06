package assets.entities;

import assets.util.Coordinates;

public final class Invader extends Entity implements Fireable {

	public Invader(Coordinates position) {
		super(position, Allegiance.HOSTILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
