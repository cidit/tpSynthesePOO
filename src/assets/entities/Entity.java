package assets.entities;

import assets.entities.enumerations.Allegiance;
import assets.entities.enumerations.Direction;
import assets.entities.enumerations.Status;
import assets.entities.interfaces.Movable;
import assets.util.Coordinate;
import assets.util.Hitbox;

public abstract class Entity implements Movable {

	protected Allegiance allegiance;
	protected Status status;
	protected Direction direction;
	protected Hitbox hitbox;

	public Entity(Hitbox hitbox, Allegiance allegiance) {
		this.hitbox = hitbox;
		this.allegiance = allegiance;
		status = Status.OPERATIONAL;
		direction = Direction.NONE;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public Allegiance getAllegiance() {
		return allegiance;
	}

	public Status getStatus() {
		return status;
	}

	public Direction getDirection() {
		return direction;
	}

	public void changeDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void move() {
		int x = hitbox.getCoordinate().getX() + direction.getXVariation();
		int y = hitbox.getCoordinate().getY() + direction.getYVariation();
		hitbox.moveTo(new Coordinate(x, y));
	}

	@Override
	public void rectify(Hitbox game) {
		int x, y;
		x = y = 0;
		if(game.contains(hitbox))
			return;
		if (hitbox.getSides().getLeft() < game.getSides().getLeft())
			x = game.getSides().getLeft();
		if (hitbox.getSides().getRight() > game.getSides().getRight())
			x = game.getSides().getRight() - hitbox.getDimention().getWidth();
		if (hitbox.getSides().getTop() < game.getSides().getTop())
			y = game.getSides().getTop();
		if (hitbox.getSides().getBottom() > game.getSides().getBottom())
			y = game.getSides().getBottom() - hitbox.getDimention().getHeight();
		hitbox.moveTo(new Coordinate(x, y));
	}
	
	@Override
	public void teleport(Coordinate coordinate) {
		hitbox.moveTo(coordinate);
	}

	public static boolean checkColision(Entity a, Entity b) {
		if (a.allegiance == b.allegiance)
			return false;
		if (!a.hitbox.intersects(b.hitbox))
			return false;
		a.status = b.status = Status.DESTROYED;
		return true;
	}
}
