package assets.entities;

import assets.util.Coordinates;
import assets.util.EuclidianVector;

public abstract class Entity implements Movable {

	protected EuclidianVector movementVector;
	protected Allegiance allegiance;
	protected Status status;
	private Direction direction;

	public Entity(Coordinates position, Allegiance allegiance) {
		movementVector = new EuclidianVector(position, position);
		this.allegiance = allegiance;
		status = Status.OPERATIONAL;
		direction = Direction.NONE;
	}

	public Coordinates getPosition() {
		return movementVector.getInitialPoint();
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
		EuclidianVector directionMovement = direction.getMovement();
		this.movementVector.setProjections(directionMovement.getXProjection(), directionMovement.getYProjection(), 0);
	}

	@Override
	public void move() {
		Coordinates nextPosition = movementVector.getTerminalPoint();
		movementVector.setInitialPoint(nextPosition);
	}

	@Override
	public void fixPosition(int width, int height) {
		Coordinates position = movementVector.getInitialPoint();
		float x = position.getX(), y = position.getY();
		if (x > width)
			x = width;
		if (x < 0)
			x = 0;
		if (y > height)
			y = height;
		if (y < 0)
			y = 0;
		Coordinates newPosition = new Coordinates(x, y);
		movementVector.setInitialPoint(newPosition);
	}

	public static void collide(Entity a, Entity b) {
		if (a.allegiance != b.allegiance)
			a.status = b.status = Status.DESTROYED;
	}
}
