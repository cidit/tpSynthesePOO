package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Status;
import assets.util.Coordinates;
import assets.util.Dimention;

public final class Missile extends Entity {

	public Missile(Coordinates position, Allegiance allegiance) {
		super(position, allegiance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void borderReaction(Dimention game) {
		int x = position.getX(), y = position.getY();
		if (x > game.getWidth() || x < 0 || y > game.getHeight() || y < 0)
			status = Status.DESTROYED;
	}
}
