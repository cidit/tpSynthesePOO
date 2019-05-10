package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Status;
import assets.util.Coordinate;
import assets.util.Hitbox;
import engine.DimensionProfiles;

public final class Missile extends Entity {

	public Missile(Coordinate coordinate, Allegiance allegiance) {
		super(new Hitbox(coordinate, DimensionProfiles.MISSILE.get()), allegiance);
	}

	@Override
	public void reactToBorder(Hitbox game) {
		super.reactToBorder(game);
		final boolean ct, cr, cb, cl;
		ct = hitbox.getSides().getTop() == game.getSides().getTop();
		cr = hitbox.getSides().getRight() == game.getSides().getRight();
		cb = hitbox.getSides().getBottom() == game.getSides().getBottom();
		cl = hitbox.getSides().getLeft() == game.getSides().getLeft();
		if (ct || cr || cb || cl)
			status = Status.DESTROYED;
	}
}
