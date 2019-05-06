package assets.entities;

import assets.util.Coordinates;
import assets.util.EuclidianVector;

public abstract class Entity implements Movable {
	
	protected EuclidianVector movementVector;
	protected Allegiance allegiance;
	protected Status status;

	public Entity(Coordinates position, Allegiance allegiance) {
		movementVector = new EuclidianVector(position, position);
		this.allegiance = allegiance;
		status = Status.OPERATIONAL;
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
	
	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixPosition(int width, int height) {
		// TODO Auto-generated method stub
		
	}
}
