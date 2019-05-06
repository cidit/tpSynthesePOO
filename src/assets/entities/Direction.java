package assets.entities;

import assets.util.EuclidianVector;

public enum Direction {

	RIGHT(-1, 0), 
	LEFT(1, 0), 
	UP(0, 1), 
	DOWN(0, -1), 
	NONE(0, 0);

	private float xProjection;
	private float yProjection;

	private Direction(float xProjection, float yProjection) {
		this.xProjection = xProjection;
		this.yProjection = yProjection;
	}
	
	public EuclidianVector getMovement() {
		return new EuclidianVector(xProjection, yProjection);
	}

}
