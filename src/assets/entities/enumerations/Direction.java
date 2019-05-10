package assets.entities.enumerations;

public enum Direction {

	RIGHT(1, 0), 
	LEFT(-1, 0), 
	UP(0, -1), 
	DOWN(0, 1), 
	NONE(0, 0);
 
	private int xVariation;
	private int yVariation;

	private Direction(int xVariation, int yVariation) {
		this.xVariation = xVariation;
		this.yVariation = yVariation;
	}
	
	public int getXVariation() {
		return xVariation;
	}
	
	public int getYVariation() {
		return yVariation;
	}

}
