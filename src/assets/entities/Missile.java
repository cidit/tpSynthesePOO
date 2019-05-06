package assets.entities;

import assets.util.Coordinates;

public final class Missile extends Entity {

	public Missile(Coordinates position, Allegiance allegiance) {
		super(position, allegiance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void borderReaction(int width, int height) {
		float x = position.getX(), y = position.getY();
		if (x > width || x < 0 || y > height || y < 0)
			status = Status.DESTROYED;
	}
}
