package assets.entities;

import assets.util.Coordinates;

public class Invader extends Entity implements Firable {

	public Invader(Coordinates position, Allegiance allegiance) {
		super(position, allegiance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
