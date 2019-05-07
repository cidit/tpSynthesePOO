package assets.entities;

import assets.util.Coordinates;
import assets.util.Dimention;

public abstract class Entity implements Movable {

	protected Coordinates position;
	protected Allegiance allegiance;
	protected Status status;
	private Direction direction;

	public Entity(Coordinates position, Allegiance allegiance) {
		this.position = position;
		this.allegiance = allegiance;
		status = Status.OPERATIONAL;
		direction = Direction.NONE;
	}

	public Coordinates getPosition() {
		return position;
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

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void move() {
		int x = position.getX() + direction.getXVariation();
		int y = position.getY() + direction.getYVariation();
		position = new Coordinates(x, y);
	}

	@Override
	public void borderReaction(Dimention game) {
		int x = position.getX(), y = position.getY();
		if (x > game.getWidth())
			x = game.getWidth();
		if (x < 0)
			x = 0;
		if (y > game.getHeight())
			y = game.getHeight();
		if (y < 0)
			y = 0;
		position = new Coordinates(x, y);
	}
	
	@Override
	public void teleport(Coordinates newCoords) {
		position = newCoords;
	}

	public static void collide(Entity a, Entity b) {
		if (a.allegiance != b.allegiance)
			a.status = b.status = Status.DESTROYED;
	}
}
