package assets.entities;

import assets.util.Coordinates;

public final class Canon extends Entity implements Firable {

	public Canon(Coordinates position) {
		super(position, Allegiance.FRIENDLY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
