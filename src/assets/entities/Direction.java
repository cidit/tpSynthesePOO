package assets.entities;

import assets.util.EuclidianVector;

public enum Direction {

	RIGHT(-1, 0), 
	LEFT(1, 0), 
	UP(0, 1), 
	DOWN(0, -1), 
	NONE(0, 0);

	private float xVariation;
	private float yVariation;

	private Direction(float xVariation, float yVariation) {
		this.xVariation = xVariation;
		this.yVariation = yVariation;
	}
	
	public float getXVariation() {
		return xVariation;
	}
	
	public float getYVariation() {
		return yVariation;
	}

}
