package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Status;
import assets.util.Hitbox;

public final class Missile extends Entity {

	public Missile(Hitbox hitbox, Allegiance allegiance) {
		super(hitbox, allegiance);
	}

	@Override
	public void rectify(Hitbox game) {
		super.rectify(game);
		final boolean ct, cr, cb, cl;
		ct = hitbox.getSides().getTop() == game.getSides().getTop();
		cr = hitbox.getSides().getRight() == game.getSides().getRight();
		cb = hitbox.getSides().getBottom() == game.getSides().getBottom();
		cl = hitbox.getSides().getLeft() == game.getSides().getLeft();
		if (ct || cr || cb || cl)
			status = Status.DESTROYED;
	}
}
